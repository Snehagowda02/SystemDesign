
## Architecture selection
*First see the problem*
what problem we are solving? business goal?
scalability - traffic and data
performance
maintainability


## Monolithic architecture
- entire application is built and deployed as single unit,
ui, business logic, dal, database - all live withing same codebase and share same deployment process.
advantage- simplicity, devl, testing , deubgging are easier
(in monolithic there is no distributed comm, service discovery mehanism, inter-service dep to manage)
- disadvantage - even if one module experience traffic, whole system needs to be scaled, 
if codebase grows difficult to manage, single point of failure

## N-tier Archite
a system split into multiple layers
managing code and understanding with clear layers
 Presentation layer, business layer, DAL, Database
-Oneportal backend service ( N-tier not 3 tier)
User -> Frontend -> LB -> API Gateway -> Backend -> Database
- disadvantage - latency (caching helps)


## Microservice architecture
independent to each other - development, deployment, scalability, managing
Distributed system

-disadvantege - microservice replaced application complexity with distributed system complexity - now it is[n/w call] -service discovery, n/w latency, monitoring, retries, tracing, data consistency , operation excellence(DevOps)


User service, order service, payment service, notification ,logging(storage)
production failure - logging ,monitoring ,tracing
SRP - 
Domain Driven Design

Autoscaling - kubernetes will do it
database scaling techniques - read replicas(distributes read-heavy workloads across multiple database), sharding(partition data into smaller segements based on keys cutomerID, tenantId, geo region)
Ex: Netflix, Uber, Amazon


## Event-Driven Architecture
-- loose coupling
-- ex: when order is placed- inventory update
                            - payment processing
                            - notification
                            - shipping workflows
one event triggers all these
asynchronous processing , high traffic tolerance
Trade off -- debugging - distributed tracing , data consistency, 

ex: Trading system, real time platform, streaming platform 

### PUbSub
* -- producer broadcasts, interested subscriber receive it , highly decoupled, notification , alert
RabbitMQ, AWS SNS
### event streaming
* -- ordered durable log
events are stored, consumer process at diff times
preserve event history
Kafka, AWS Kinesis (immutable logs)

challenges -- 
- no immediate data synchronization [ eventual consistency ]
- ordering is important ( what if payment done but order not updated - kafka provide partitioning for this)
- duplicate event delivery is trade off ( need to handle this)
- dead letter queue for failed msg






