echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin


cd ../booking-module

./gradlew bootBuildImage

cd ../routing-service

./gradlew bootBuildImage


docker push nickadamu/booking-service
docker push nickadamu/routing-service

