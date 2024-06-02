package com.nexusnova.lifetravelapi.config;

import com.nexusnova.lifetravelapi.app.assets.domain.model.Temperature;
import com.nexusnova.lifetravelapi.app.assets.domain.services.TemperatureCommandService;
import jakarta.transaction.Transactional;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class MqttConfig {

    private static final String MQTT_URL = "tcp://localhost:1883";
    private static final String CLIENT_ID = "spring-boot-mqtt";
    private static final int BATCH_SIZE = 10;
    private final TemperatureCommandService temperatureCommandService;
    List<String> batch = new ArrayList<>();

    public MqttConfig(TemperatureCommandService temperatureCommandService) {
        this.temperatureCommandService = temperatureCommandService;
    }

    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageProducer inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(MQTT_URL, CLIENT_ID, "test/topic");
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }
    private void saveBatch(List<String> batch) {
        List<Temperature> temperatures = batch.stream()
                .map(payload -> {
                    Temperature temperature = new Temperature();
                    temperature.setValue(Double.parseDouble(payload));
                    temperature.setMeasuredAt(new Date());
                    temperature.setDeleted(false);
                    return temperature;
                })
                .collect(Collectors.toList());
        temperatureCommandService.addTemperatures(temperatures);
    }
    @ServiceActivator(inputChannel = "mqttInputChannel")
    @Transactional
    public void handleMessage(Message<String> message) {
        batch.add(message.getPayload());

        if (batch.size() >= BATCH_SIZE) {
            saveBatch(batch);
            batch.clear();
        }
    }

    /** One by one
    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return message -> {
            // Manejar el mensaje recibido aquí
            String payload = (String) message.getPayload();
            try {
                double temperatureValue = Double.parseDouble(payload);
                Temperature temperature = new Temperature();
                temperature.setValue(temperatureValue);
                temperature.setMeasuredAt(new Date());
                temperature.setDeleted(false);
                temperatureCommandService.addTemperature(temperature);
                System.out.println("Mensaje recibido y guardado en la base de datos: " + payload);
            } catch (NumberFormatException e) {
                System.out.println("Error al parsear la temperatura: " + e.getMessage());
            }
        };
    }
     */

    @Bean
    public MqttConnectOptions mqttConnectOptions() {
        MqttConnectOptions options = new MqttConnectOptions();
        // Configurar opciones de conexión MQTT aquí (si es necesario)
        return options;
    }
}
