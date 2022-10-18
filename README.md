# Meilyv

---

## Setup
## With Docker
With [Docker Compose](https://docs.docker.com/compose/) you can start all services inside a docker container. This helps you to start specific services fast and easily.

### Build and start
To build and start all services run `docker-compose up -d`.

To start a specific service run `docker-compose up -d <service>`.

### Update (rebuild)
If you want to update all containers if you made changes run the command with the `--build` flag e.g `docker-compose up -d --build`.

If you want to update a container if you made changes run the command with the `--build` flag e.g `docker-compose up -d --build <service>`.

---

## Without Docker
To set up each three services without docker for this project, follow these steps.

### Database
Start the database with  `docker-compose up -d meilyv-database`.

### Backend
Start the main class with IntelliJ