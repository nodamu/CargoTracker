echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin


cd ../booking-module

./gradlew jib

cd ../routing-service

./gradlew jib




