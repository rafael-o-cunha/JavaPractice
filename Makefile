IMAGE_NAME := java-practice
CONTAINER_NAME := java-practice-run

.PHONY: build run clean rebuild

build:
	docker build -t $(IMAGE_NAME) .

run: build
	docker run --rm --name $(CONTAINER_NAME) $(IMAGE_NAME)

rebuild:
	docker build --no-cache -t $(IMAGE_NAME) .

clean:
	docker rmi -f $(IMAGE_NAME) || true
