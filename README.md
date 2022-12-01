# Commands
## MongoDB
docker run --name=mongo --rm --network=timer -p 27017:27017 mongo
## Timer
docker run --name=timer2 --rm --network=timer -p 8080:8080 -e MONGO_URL=mongodb://mongo:27017/dev szalaigeri/timer:3.0.0