Notification is making as SSE
SSE is actually designed to keep a long-lived HTTP connection open.

in-application notification SSE can be good fit

Drawback: 
Attacker can create many connections and keep it open -- mitigation -- rate limiting, connection limits per User/IP, Reverse proxies

//
in large systems
The Notification Service  -- it already owns all SSE connections, so it immediately pushes to the right user.

Users SSE connection is on app1
user2: creates notification in APP2

App2 cannot push directly to App1, in this case need shared mechanism - Redis Pub-sub/brokers

SSE security doesn't come in how long you keep, it comes in how you secured

AUTHENTICATE AND MANAGE CONNECTION
use: HTTPS, authenticate user, close connection when session expires or token expires
token expiry should be there 