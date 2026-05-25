COMPOSE=docker compose \
	--env-file infra/.env \
	-f infra/docker-compose.yml

APP_CONTAINER=pets_app

build:
	$(COMPOSE) build

up:
	$(COMPOSE) up -d

down:
	$(COMPOSE) down

restart:
	$(COMPOSE) restart

logs:
	$(COMPOSE) logs -f

ps:
	$(COMPOSE) ps

clean:
	$(COMPOSE) down -v
	rm -rf infra/postgres/data

exec:
	docker exec -it $(APP_CONTAINER) bash

exec-db:
	docker exec -it pets_db bash

mvn-package:
	$(COMPOSE) exec app mvn clean package

mvn-test:
	$(COMPOSE) exec app mvn test

db-reset:
	$(COMPOSE) down -v
	rm -rf infra/postgres/data
	$(COMPOSE) up -d