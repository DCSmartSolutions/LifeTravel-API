-- ROLES INFO
INSERT INTO roles (name)
VALUES
    ('ROLE_TOURIST'),
    ('ROLE_AGENCY');

-- ACTIVITIES INFO
INSERT INTO activities (title, img_url, created_date, deleted)
VALUES
    ('Camping', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/activities/camping.png', NOW(), 0),
    ('Hiking', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/activities/hiking.png', NOW(), 0),
    ('Skiing', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/activities/skiing.png', NOW(), 0),
    ('Rafting', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/activities/rafting.png', NOW(), 0),
    ('Cycling', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/activities/cycling.png', NOW(), 0),
    ('Kayaking', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/activities/kayaking.png', NOW(), 0),
    ('Surfing', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/activities/surfing.png', NOW(), 0),
    ('Diving', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/activities/diving.png', NOW(), 0),
    ('Sightseeing', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/activities/sightseeing.png', NOW(), 0),
    ('QuadBiking', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/activities/quadbiking.png', NOW(), 0);

-- REGIONS INFO
INSERT INTO regions (title, img_url, description, created_date, deleted)
VALUES
    ('Coast', 'https://iot2023.blob.core.windows.net/imgs/regions/costa.jpg', 'The coast is where land and sea converge, shaping diverse ecosystems and breathtaking vistas.', NOW(), 0),
    ('Mountain Range', 'https://iot20231.blob.core.windows.net/imgs/regions/sierra.jpg', 'Mountain ranges are majestic geological formations, with towering peaks and unique ecosystems.', NOW(), 0),
    ('Jungle', 'https://iot20231.blob.core.windows.net/imgs/regions/selva.jpg', 'Jungles are lush, dense forests teeming with diverse wildlife, exotic plants, and untamed beauty.', NOW(), 0);

-- DEPARTMENTS INFO
INSERT INTO departments (name, region_id, created_date, deleted)
VALUES
    ('Lima', 1, NOW(), 0),
    ('Tumbes', 1, NOW(), 0),
    ('Piura', 1, NOW(), 0),
    ('Lambayeque', 1, NOW(), 0),
    ('La Libertad', 1, NOW(), 0),
    ('Ancash', 1, NOW(), 0),
    ('Ica', 1, NOW(), 0),
    ('Arequipa', 1, NOW(), 0),
    ('Moquegua', 1, NOW(), 0),
    ('Tacna', 1, NOW(), 0),

    ('Apurimac', 2, NOW(), 0),
    ('Ayacucho', 2, NOW(), 0),
    ('Cajamarca', 2, NOW(), 0),
    ('Cuzco', 2, NOW(), 0),
    ('Huanuco', 2, NOW(), 0),
    ('Huancavelica', 2, NOW(), 0),
    ('Junin', 2, NOW(), 0),
    ('Pasco', 2, NOW(), 0),
    ('Puno', 2, NOW(), 0),

    ('Loreto', 3, NOW(), 0),
    ('Amazonas', 3, NOW(), 0),
    ('San Martin', 3, NOW(), 0),
    ('Ucayali', 3, NOW(), 0),
    ('Madre de Dios', 3, NOW(), 0);

-- USERS INFO
INSERT INTO users (id, email, google_name, google_photo_url, created_date, deleted, role_id)
VALUES
    ('BNqsE6gkjlZoEVIxf9qt92lXyJB3', 'agency1@gmail.com', 'Agencia_1', '', NOW(), 0,2),
    ('RKOQXaT4hHhU7sCMOnXgnwKm1Cf2', 'agency2@gmail.com', 'Agencia 2', '', NOW(), 0,2),
    ('y5Q3OYSN5vdVHLyOkKzPvup7ojA3', 'role_agency@gmail.com', 'Agencia 3', '', NOW(), 0,2),
    ('6WKjj6oyzrMTUfuw8j7vEks3Yuu1', 'tourist1@gmail.com', 'Turista 1', '', NOW(), 0,2),
    ('MxqYidFJ94c17BkAiCOkpGxwwKD3', 'tourist2@gmail.com', 'Turista 2', '', NOW(), 0,2),
    ('TJbWODP4xwOMvgwyqrYrbPeDnlZ2', 'tourist3@gmail.com', 'Turista 3', '', NOW(), 0,2);

-- AGENCIES INFO
INSERT INTO agencies (user_id, ruc, address, agency_photo_url, description, legal_name, phone_number, web_page_url, created_date, deleted)
VALUES
    ('BNqsE6gkjlZoEVIxf9qt92lXyJB3', 20602698603, 'Av Alcanflores 1190, Miraflores', 'https://iot20232.blob.core.windows.net/imgs/agencies/agencia1.jpg',
     'Agencia de viajes con gran experiencia en tours locales de la ciudad', 'FerturPeru Travel S.A.C.', '992817047', 'www.ferturtravel.pe', NOW(), 0),
    ('RKOQXaT4hHhU7sCMOnXgnwKm1Cf2', 20419624021, 'C. Jerusalen 603, Arequipa', 'https://iot20232.blob.core.windows.net/imgs/agencies/agencia2.jpg',
     N'Agencia premiada por la ONT por 3 años consecutivos.', 'Tierra Adentro S.A.C.', '996593729', 'www.tierraadentro.com.pe', NOW(), 0),
    ('y5Q3OYSN5vdVHLyOkKzPvup7ojA3', 20605476971, 'C. Mercaderes 224, Cuzco', 'https://iot20232.blob.core.windows.net/imgs/agencies/agencia3.jpg',
     'Somos lideres en turismo internacional y trilingue de las mejores ruinas de LATAM', 'Inka Travel S.A.C.', '987112633', 'www.incatravel.com', NOW(), 0);
INSERT INTO tour_packages (agency_id, region_id, department_id, title, description, img_url, price, rating, latitude, longitude, visible, created_date, deleted)
VALUES
    (1, 2, 14, 'Trekking in Machu Picchu',
     'Machu Picchu, located in the Cusco region of Peru, is one of the most iconic archaeological sites in the world. This ancient Inca citadel, nestled high in the Andes, offers breathtaking views and a deep sense of history. Explore its mysterious ruins, terraced fields, and the famous Intihuatana stone. A trek to Machu Picchu is a journey through time and culture.',
     'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/1.jpg', 345, 3.4, -13.163141, -72.544963, 1, NOW(), 0),
    (1, 2, 14, 'Trekking in Aguas Calientes',
     'Aguas Calientes, also known as Machu Picchu Pueblo, is a charming town located at the base of Machu Picchu. It serves as the gateway for visitors to the ancient citadel. Enjoy a trek through lush forests and alongside the Urubamba River as you make your way to Machu Picchu. Aguas Calientes offers a variety of accommodations, hot springs, and local cuisine to enhance your visit.',
     'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/2.jpg', 125, 2.9, -13.163141, -72.544963, 1, NOW(), 0),
    (1, 1, 7, 'Reserva Nacional de Paracas',
     'The Paracas National Reserve, located in the Ica region, is a unique natural wonder. It is home to a diverse marine ecosystem, where you can spot sea lions, penguins, and an array of bird species. Explore the stunning Paracas Peninsula, characterized by dramatic cliffs and red sand beaches. The Ballestas Islands are a must-visit, often referred to as the ''Poor Man''s Galapagos'' due to their rich biodiversity.',
     'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/3.jpg', 345, 3.4, -13.813835, -76.388499, 1, NOW(), 0),
    (1, 3, 20, 'Trekking in Senderos de la Amazonia',
     'The Amazon Rainforest in the Iquitos region is a treasure trove of biodiversity and adventure. Immerse yourself in the lush greenery and hear the symphony of the jungle. Trek through the jungle to discover visible waterfalls, unique flora, and wildlife, including monkeys and exotic birds. This is an opportunity to experience the natural wonders of the Amazon up close.',
     'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/4.jpg', 345, 3.4, -3.74912, -73.25383, 1, NOW(), 0),
    (1, 3, 20, 'Trekking in Senderos de la Amazonia',
     'The Amazon Rainforest in the Iquitos region is a treasure trove of biodiversity and adventure. Immerse yourself in the lush greenery and hear the symphony of the jungle. Trek through the jungle to discover visible waterfalls, unique flora, and wildlife, including monkeys and exotic birds. This is an opportunity to experience the natural wonders of the Amazon up close.',
     'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/4.jpg', 345, 3.4, -3.74912, -73.25383, 1, NOW(), 0),
    (1, 3, 20, 'Trekking in Senderos de la Amazonia',
     'The Amazon Rainforest in the Iquitos region is a treasure trove of biodiversity and adventure. Immerse yourself in the lush greenery and hear the symphony of the jungle. Trek through the jungle to discover visible waterfalls, unique flora, and wildlife, including monkeys and exotic birds. This is an opportunity to experience the natural wonders of the Amazon up close.',
     'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/4.jpg', 345, 3.4, -3.74912, -73.25383, 1, NOW(), 0),
    (1, 3, 20, 'Trekking in Senderos de la Amazonia',
     'The Amazon Rainforest in the Iquitos region is a treasure trove of biodiversity and adventure. Immerse yourself in the lush greenery and hear the symphony of the jungle. Trek through the jungle to discover visible waterfalls, unique flora, and wildlife, including monkeys and exotic birds. This is an opportunity to experience the natural wonders of the Amazon up close.',
     'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/4.jpg', 345, 3.4, -3.74912, -73.25383, 1, NOW(), 0),
    (1, 3, 20, 'Trekking in Senderos de la Amazonia',
     'The Amazon Rainforest in the Iquitos region is a treasure trove of biodiversity and adventure. Immerse yourself in the lush greenery and hear the symphony of the jungle. Trek through the jungle to discover visible waterfalls, unique flora, and wildlife, including monkeys and exotic birds. This is an opportunity to experience the natural wonders of the Amazon up close.',
     'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/4.jpg', 345, 3.4, -3.74912, -73.25383, 1, NOW(), 0),
    (1, 3, 20, 'Trekking in Senderos de la Amazonia',
     'The Amazon Rainforest in the Iquitos region is a treasure trove of biodiversity and adventure. Immerse yourself in the lush greenery and hear the symphony of the jungle. Trek through the jungle to discover visible waterfalls, unique flora, and wildlife, including monkeys and exotic birds. This is an opportunity to experience the natural wonders of the Amazon up close.',
     'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/4.jpg', 345, 3.4, -3.74912, -73.25383, 1, NOW(), 0),
    (2, 1, 7, 'Wine Tasting in Ica Valley', 'Spend a day indulging in Peru famous wine region. Tour scenic vineyards and production facilities. Learn traditional winemaking methods. Sample a variety of red and white wines. Enjoy a gourmet picnic lunch in the vineyards.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/5.jpg', 215.99, 4.2, -14.068950, -75.732451, 1, NOW(), 0),
    (1, 2, 14, 'Inca Trail Trek to Machu Picchu', 'Hike the iconic Inca Trail over 4 days to reach the ancient citadel of Machu Picchu. Pass incredible landscapes and ruins along the way. Learn about Inca history from your guide. Spend a day exploring Machu Picchu before returning to Cusco.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/6.jpg', 425.50, 4.8, -13.163141, -72.544963, 1, NOW(), 0),
    (3, 1, 8, 'Explore Colca Canyon', 'Descend into the massive Colca Canyon, deeper than the Grand Canyon. Stay in a lodge and enjoy the dramatic views. See Andean condors soaring above. Visit local villages and learn ancient agricultural techniques still in use today.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/7.jpg', 350.25, 4.3, -15.627031, -71.375774, 0, NOW(), 0),
    (2, 3, 22, 'Amazon Jungle Adventure', 'Explore the Peruvian Amazon by boat and on foot. Spot incredible wildlife like monkeys, sloths, toucans and more. Fish for piranha. Trek through dense jungle. Stay in an eco-lodge. Learn about conservation efforts in the Amazon Basin.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/8.jpg', 499.99, 4.7, -4.097862, -72.886292, 1, NOW(), 0),
    (1, 1, 4, 'Moche Ruins and Beach Getaway', 'Tour the ancient Moche ceremonial sites and see preserved friezes and huaca pyramids. Then head to the coast near Trujillo for sunshine, sand and surfing. Stay in a beachfront hotel. Enjoy the amazing seafood cuisine.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/9.jpg', 425.99, 3.9, -8.119043, -79.021902, 1, NOW(), 0),
    (3, 3, 24, 'Wildlife Encounter in Manu Park', 'Explore the incredible biodiversity of Manu National Park. Spot exotic birds like macaws, toucans and tanagers. See monkeys, sloths, tapirs and maybe even jaguars deep in the jungle. Stay in an eco-lodge. Go river rafting and canopy ziplining.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/10.jpg', 799.00, 4.5, -11.770780, -71.418007, 1, NOW(), 0),
    (2, 2, 15, 'Textile Traditions in Andean Villages', 'Visit remote villages around Huanuco. Learn about traditional Andean textile methods and meanings. See weavers demonstrate techniques passed down for generations. Buy handmade textiles and crafts directly from the artisans.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/11.jpg', 299.50, 4.6, -9.918731, -76.239120, 1, NOW(), 0),
    (1, 2, 13, 'Mountain Biking the Andes', 'Ride downhill trails through stunning high altitude scenery. Pedal past lakes, valleys and mountain peaks. Stay in Cajamarca and other charming villages. Sample delicious local cuisine after your bike adventures each day.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/12.jpg', 425.00, 4.1, -7.183440, -78.514916, 0, NOW(), 0),
    (3, 3, 23, 'Explore the Amazon by Boat', 'Cruise down the mighty Amazon, Ucayali and Maranon rivers. Search for pink river dolphins. Fish for piranha. Visit Yacapana villages. Hike into the jungle to find wildlife. Sleep aboard the comfortable boat each night.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/13.jpg', 599.75, 4.2, -8.385543, -74.496569, 1, NOW(), 0),
    (2, 1, 8, 'Culinary Journey through Arequipa', 'Take your tastebuds on a tour of Arequipas amazing food scene. Learn traditional cooking methods. Visit local markets. Make cheese, chocolates and more. Enjoy meals at top restaurants around the city.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/14.jpg', 350.50, 4.7, -16.409048, -71.537704, 1, NOW(), 0),
    (1, 1, 1, 'Lima City Highlights', 'Discover Perus cosmopolitan capital on a tour of Limas top sights. Explore well-preserved colonial centers. Marvel at opulent cathedrals and palaces. Sample ceviche and Pisco sours. Enjoy an unforgettable Peruvian dinner and folkloric show.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/15.jpg', 299.99, 4.3, -12.046374, -77.042793, 1, NOW(), 0),
    (3, 3, 20, 'Tropical Paradise in Iquitos', 'Unwind in the lush Amazon city of Iquitos. Stay in a bungalow along the Itaya River. Take a boat tour to see wildlife. Visit local markets. Experience an Ayahuasca retreat. Indulge in delicious rainforest fruits and fish.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/16.jpg', 425.25, 4.6, -3.749283, -73.247133, 1, NOW(), 0),
    (2, 1, 6, 'Mountain Lodge Trek in Huaraz', 'Trek to breathtaking alpine lakes and glaciers near Huaraz. Spend nights at cozy mountain lodges. Ride horses. Learn ancient Andean agricultural techniques. Immerse yourself in rural Quechua culture away from the tourist crowds.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/17.jpg', 475.75, 4.5, -9.530773, -77.595827, 1, NOW(), 0),
    (1, 3, 21, 'Rafting and Ziplining in Amazonas', 'Paddle down rushing jungle rivers near Chachapoyas. Camp along the river banks. Hike to stunning waterfalls. Zoom through the cloud forest on ziplines for breathtaking views. Spot toucans and parrots in the trees around you.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/18.jpg', 350.00, 4.8, -6.505548, -77.856285, 1, NOW(), 0),
    (3, 2, 19, 'Lake Titicaca Homestay', 'Stay with an indigenous Uros family on floating islands. Learn ancient fishing and boat building skills. Tour incredible islands and ruins on and around the lake. Experience traditional music, dress and foods.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/19.jpg', 299.99, 3.9, -15.844722, -70.016778, 1, NOW(), 0),
    (1, 3, 24, 'Adventure in Madre de Dios', 'See incredible wildlife in one of the most biodiverse places on Earth. Spot macaws, monkeys and more. Stay in an eco-lodge deep in the jungle. Go river rafting and canopy ziplining for breathtaking views.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/20.jpg', 599.99, 4.8, -12.574, -69.100977, 1, NOW(), 0),
    (2, 2, 18, 'Mountain Getaway in Pasco', 'Stay in a charming mountain lodge outside Oxapampa. Go horseback riding to stunning waterfalls and lakes. Hike through hillside villages. Unwind in natural hot springs. Sample delicious local cuisine.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/21.jpg', 299.75, 4.3, -10.572579, -75.233710, 1, NOW(), 0),
    (3, 1, 2, 'Beach Resort Stay in Tumbes', 'Spend your days lounging on pristine beaches and swimming in clear waters. Stay at an all-inclusive beachfront resort. Snorkel and spot sea life. Visit mangroves and waterfalls. Indulge in fresh ceviche.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/22.jpg', 425.50, 4.1, -3.55, -80.422675, 1, NOW(), 0),
    (1, 3, 21, 'Kayaking and Camping in Amazonas', 'Paddle down jungle rivers and sleep in tents on white sand beaches. Visit waterfalls and natural pools. Hike through rainforests to spot wildlife. Learn about local culture in riverside communities.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/23.jpg', 425.25, 4.5, -5.129381, -78.157446, 1, NOW(), 0),
    (2, 2, 19, 'Island Homestay on Lake Titicaca', 'Immerse yourself in ancient traditions on the islands of Lake Titicaca. Stay with a local family. Learn ancient agriculture, fishing, cooking and textile methods. Tour incredible islands and ruins.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/24.jpg', 299.50, 4.7, -15.835833, -69.959722, 1, NOW(), 0),
    (3, 1, 8, 'Hiking and Biking in Arequipa', 'Explore Arequipa and the surrounding volcanoes. Hike through river canyons and valleys. Bike down mountain trails with incredible scenery. Relax in natural hot springs. Sample great food and wine.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/25.jpg', 475.25, 4.3, -16.39889, -71.535909, 1, NOW(), 0),
    (1, 1, 6, 'Cultural Journey through Ancash', 'Experience authentic rural culture in charming mountain villages. Learn ancient traditions still alive today. Visit local markets full of handmade crafts. Tour pre-Incan archaeological sites off the beaten path.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/26.jpg', 299.75, 4.6, -9.065002, -77.599732, 0, NOW(), 0),
    (2, 3, 20, 'Iquitos Food and Culture', 'Sample exotic Amazonian cuisine in Perus vibrant jungle metropolis. Check out markets brimming with rainforest delicacies. Experience traditional music and dance shows. Tour the historic city by tuk-tuk.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/27.jpg', 350.00, 4.2, -3.748717, -73.282780, 1, NOW(), 0),
    (3, 1, 6, 'Surf and Sun in Ancash', 'Catch waves and soak up sunshine along the scenic Ancash coastline. Stay beachside in a charming village. Tackle beginner and advanced surf breaks. Tour archaeological sites and sample fresh seafood.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/28.jpg', 375.00, 4.1, -9.145008, -78.526707, 1, NOW(), 0),
    (1, 2, 14, 'Sacred Valley Culture and Adventure ', 'Experience the magic of the Sacred Valley. Visit magnificent Inca ruins and colourful markets. Learn ancient Andean textile methods. Go horseback riding, hiking and mountain biking in the Andes.', 'https://nexusnovastorage.blob.core.windows.net/tour-packages-images/imgs/tours/29.jpg', 425.75, 4.6, -13.424657, -72.089941, 1, NOW(), 0);
-- TOURISTS INFO
INSERT INTO tourists (user_id, name, birth_date, phone_number, photo_url, emergency_phone_number, created_date, deleted)
VALUES
    ('6WKjj6oyzrMTUfuw8j7vEks3Yuu1', 'David Sanchez', '1990-05-15', '+51 987 654 321', 'https://example.com/photo1.jpg', '+51 999 888 777', NOW(), 0),
    ('MxqYidFJ94c17BkAiCOkpGxwwKD3', 'Milton Chinchay', '1985-08-20', '+51 987 654 322', 'https://example.com/photo2.jpg', '+51 999 888 778', NOW(), 0),
    ('TJbWODP4xwOMvgwyqrYrbPeDnlZ2', 'Henry Diaz', '1998-03-10', '+51 987 654 323', 'https://example.com/photo3.jpg', '+51 999 888 779', NOW(), 0);

-- REVIEWS INFO
INSERT INTO reviews (created_date, updated_date, deleted, tourist_id, tour_package_id, rating, review_text)
VALUES
    (NOW(), NULL, 0, 1, 5, 4, 'The tour was amazing! I wish there were more benches with shade along the way.'),
    (NOW(), NULL, 0, 2, 15, 5, 'Absolutely loved the tour! The guides were so knowledgeable and friendly.'),
    (NOW(), NULL, 0, 3, 25, 3, 'An average experience. It would have been better with clearer directions.'),
    (NOW(), NULL, 0, 1, 10, 4, 'Fantastic tour, but it would be perfect with more restroom breaks.'),
    (NOW(), NULL, 0, 2, 20, 5, 'Best tour ever! The scenery was breathtaking, and the activities were so much fun.'),
    (NOW(), NULL, 0, 3, 30, 2, 'A bit disappointed, the tour didn''t quite meet my expectations.'),
    (NOW(), NULL, 0, 1, 1, 5, 'Unforgettable experience! I loved every moment of it.'),
    (NOW(), NULL, 0, 2, 12, 4, 'Very informative tour. It would have been even better with more interaction with locals.'),
    (NOW(), NULL, 0, 3, 28, 3, 'Good tour, but the organization could improve. It was hard to follow at times.'),
    (NOW(), NULL, 0, 1, 8, 4, 'Highly recommended! I wish I had more time to explore each stop on the tour.');
