IMAGE_NAME := java-practice-image
CONTAINER_NAME := sudoku
WORKDIR := $(PWD)

USER_ID := $(shell id -u)
GROUP_ID := $(shell id -g)

.PHONY: build shell run detached stop clean rebuild

build:
	docker build -t $(IMAGE_NAME) .

shell:
	docker run --rm -it \
		--name $(CONTAINER_NAME) \
		--user $(USER_ID):$(GROUP_ID) \
		-v $(WORKDIR):/workspace \
		$(IMAGE_NAME)

run:
	docker run --rm \
		--name $(CONTAINER_NAME) \
		--user $(USER_ID):$(GROUP_ID) \
		-v $(WORKDIR):/workspace \
		$(IMAGE_NAME) \
		mvn test

detached:
	docker run -d \
		--name $(CONTAINER_NAME) \
		--user $(USER_ID):$(GROUP_ID) \
		-v $(WORKDIR):/workspace \
		$(IMAGE_NAME)

stop:
	docker stop $(CONTAINER_NAME) || true

rebuild:
	docker build --no-cache -t $(IMAGE_NAME) .

clean:
	docker rmi -f $(IMAGE_NAME) || true

