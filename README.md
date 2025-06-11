# Kotlin DDD + CQRS API 토이 프로젝트

이 프로젝트는 Kotlin을 기반으로 DDD 아키텍처와 CQRS 패턴을 적용하면서 공부하고 있는 API 서버입니다. <br/>
Kafka를 통해 도메인 이벤트를 발행하고, 이를 NoSQL DB에 반영까지 목표로 하고 있습니다.

---

## 🧱 아키텍처 구성

- **언어**: Kotlin
- **프레임워크**: Spring Boot 3.5
- **데이터 저장소**:
    - RDBMS (Write Model): MySQL
    - NoSQL (Read Model): MongoDB / Elasticsearch
- **메시징 시스템**: Kafka
- **패턴**: DDD, CQRS, Event-Driven Architecture
- **빌드 툴**: Gradle
- **도구**: Docker, GitHub Actions(CI/CD)

---

## 📂 프로젝트 구조

```markdown
src
├── domain              # 도메인 계층 (Entity, Aggregate, Value Object, Domain Service)
├── application         # 애플리케이션 계층 (UseCase, CommandHandler, QueryService 등)
├── infrastructure      # 인프라 계층 (JPA, Kafka, MongoDB, 외부 연동 등)
├── interface           # 인터페이스 계층 (Controller, Consumer 등)
└── common              # 공통 유틸, 예외, 공통 설정 등
```

---
## 로컬 임시 환경
## 💾 Database H2
- H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
  - **JDBC URL**: `jdbc:h2:mem:testdb`
  - **Username**: `sa`
  - **Password**: *(비워두기)*

---
## 🛠 API 문서 (Swagger)
- Swagger UI: http://localhost:8080/swagger-ui/index.html
- API 문서 (JSON): http://localhost:8080/v3/api-docs

