.PHONY: build

test:
	./gradlew test

build: test
	./gradlew build

run: build
	./gradlew run

check:
	./gradlew check

flyway:
	sh flyway-migrate-db.sh localhost ktor-app