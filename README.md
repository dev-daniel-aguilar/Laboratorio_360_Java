# Dino Park 

Sistema backend desarrollado con Spring Boot para la administración de un parque de dinosaurios.

El sistema permite gestionar dinosaurios, turistas, zonas del parque, control energético, eventos dinámicos, monitoreo general y generación automática de eventos aleatorios.

---

# Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Liquibase
- Maven
- Lombok
- JUnit 5
- Mockito
- Postman

---

#  Arquitectura del Proyecto

El proyecto sigue una arquitectura en capas:

```text
Controller
↓

Service
↓

Repository
↓

Entity
```
#  Flujo General del Sistema

```mermaid
flowchart TD

    A[Inicio del sistema] --> B[Spring Boot inicia]
    B --> C[Liquibase crea/actualiza tablas]
    C --> D[Usuario prueba endpoints en Postman]
    D --> E[Controller recibe petición]
    E --> F[Service aplica lógica de negocio]
    F --> G[Repository accede a MySQL]
    G --> H[Respuesta JSON al cliente]

    B --> I[Scheduler automático]
    I --> J[Genera evento aleatorio]
    J --> K[Factory crea ParkEvent]
    K --> L[Observer notifica monitoreo]
    L --> M[Evento se guarda en BD]
 ```
---
#  Diagrama de Secuencia - Evento BLACKOUT

```mermaid
sequenceDiagram
    participant Client
    participant Controller
    participant Service
    participant Factory
    participant Observer
    participant Repository
    participant DB

    Client->>Controller: POST blackout
    Controller->>Service: createBlackoutEvent()
    Service->>Factory: createEvent()
    Factory-->>Service: ParkEvent
    Service->>Observer: notifyObservers()
    Service->>Repository: save(event)
    Repository->>DB: INSERT event
    DB-->>Repository: saved
    Repository-->>Service: event
    Service-->>Controller: response
```
---
### Capas implementadas

- **Controller:** Manejo de endpoints REST
- **Service:** Lógica de negocio
- **Repository:** Acceso a datos con JPA
- **Entity:** Representación de tablas en MySQL

---

#  Módulos Principales

## Gestión de Dinosaurios

Funcionalidades:

- Registrar dinosaurios
- Consultar dinosaurios
- Actualizar información
- Eliminar dinosaurios

CRUD completo implementado.

---

##  Gestión de Turistas

Funcionalidades:

- Registrar turistas
- Consultar turistas
- Actualizar turistas
- Eliminar turistas
- Asignar turistas a zonas

---

## Gestión de Zonas

Funcionalidades:

- Crear zonas del parque
- Consultar zonas activas
- Administrar capacidad de zonas

Ejemplos de zonas:

- Observation Zone
- Central Zone
- Arrival Zone
- Bathrooms
- Energy Plant

---

##  Gestión de Planta de Energía

Funcionalidades:

- Registrar plantas de energía
- Consumir energía
- Restaurar energía
- Detectar estado LOW_POWER automáticamente

---

##  Eventos Dinámicos del Parque

Eventos implementados:

- BLACKOUT
- STORM
- DINO_ESCAPE
- VEHICLE_FAILURE
- DISCOUNT_HOUR

Los eventos afectan automáticamente el estado del parque.

Ejemplo:

```text
BLACKOUT
↓

Consume energía

↓

Genera alerta

↓

Se registra en base de datos
```

---

# Sistema de Monitoreo

El módulo de monitoreo permite consultar:

- Turistas activos
- Dinosaurios registrados
- Zonas activas
- Eventos activos
- Energía disponible

Endpoint principal:

```http
GET /monitoring/status
```

Ejemplo de respuesta:

```json
{
    "activeTourists": 1,
    "totalDinosaurs": 5,
    "activeZones": 2,
    "activeEvents": 4,
    "totalEnergyAvailable": 850
}
```

---

# Scheduler Automático

El sistema genera eventos aleatorios automáticamente cada 30 segundos utilizando Spring Scheduler.

Eventos automáticos:

- BLACKOUT
- STORM
- DINO_ESCAPE
- VEHICLE_FAILURE
- DISCOUNT_HOUR

---

# Patrones de Diseño Implementados

## Factory Pattern

Utilizado para centralizar la creación de eventos dinámicos del parque.

Clase principal:

```text
ParkEventFactory
```

---

## Observer Pattern

Utilizado para notificar automáticamente al sistema de monitoreo cuando ocurre un evento importante.

Clases principales:

```text
ParkObserver

MonitoringAlertService

ParkNotificationService
```

---

# Testing

Se implementaron pruebas unitarias utilizando:

- JUnit 5
- Mockito

Módulos probados:

- EnergyPlantService
- ParkEventService
- MonitoringService

---

# Endpoints Principales

## Dinosaurs

```http
GET /dinosaurs

POST /dinosaurs

GET /dinosaurs/{id}

PUT /dinosaurs/{id}

DELETE /dinosaurs/{id}
```

---

##  Tourists

```http
GET /tourists

POST /tourists

GET /tourists/{id}

PUT /tourists/{id}

DELETE /tourists/{id}
```

---

##  Zones

```http
GET /zones

POST /zones
```

---

## Energy Plants

```http
GET /energy-plants

POST /energy-plants

GET /energy-plants/{id}

PUT /energy-plants/{id}

DELETE /energy-plants/{id}

POST /energy-plants/{id}/consume

POST /energy-plants/{id}/restore
```

---

##  Events

```http
GET /events

POST /events/blackout

POST /events/storm

POST /events/dinosaur-escape

POST /events/vehicle-failure

POST /events/discount-hour
```

---

## Monitoring

```http
GET /monitoring/status
```

---

# Base de Datos

El proyecto utiliza:

- MySQL
- Liquibase para versionamiento de base de datos

Tablas principales:

```text
dinosaur

tourist

zone

energy_plant

park_event
```

---

# Autor

Desarrollado por Daniel.

Proyecto académico desarrollado con Java y Spring Boot.
