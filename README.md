# coffee-marketplace

### Build image (only backend)

docker build -t coffee-marketplace .

### Run container (only backend)

docker run -d -p 8080:8181 -t coffee-marketplace

### Run pgAdmin, postgres and backend

docker-compose up

### Watch result

http://localhost:8080