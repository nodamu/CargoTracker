cd booking-module

./gradlew bootBuildImage

cd ../routing-service

./gradlew bootBuildImage


echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin

docker push nickadamu/booking-service
docker push nickadamu/routing-service

