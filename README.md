# Kotlin DDD + CQRS API 토이 프로젝트

이 프로젝트는 Kotlin을 기반으로 DDD 아키텍처와 CQRS 패턴을 적용한 API 서버입니다. <br/>
Kafka를 통해 도메인 이벤트를 발행하고, 이를 NoSQL DB(MongoDB 등)에 반영하여 확장성과 조회 성능을 강화하는 구조입니다.

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
gi
## 📂 프로젝트 구조

```markdown
src
├── domain              # 도메인 계층 (Entity, Aggregate, Value Object, Domain Service)
├── application         # 애플리케이션 계층 (UseCase, CommandHandler, QueryService 등)
├── infrastructure      # 인프라 계층 (JPA, Kafka, MongoDB, 외부 연동 등)
├── interface           # 인터페이스 계층 (Controller, Consumer 등)
└── common              # 공통 유틸, 예외, 공통 설정 등
