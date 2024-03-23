# Калькулятор отпускных
Небольшой тестовый проект на Spring'е с web сервером, который по двум эндпоинтам считаем отпускные.
Есть тесты и небольшая структура.

### Api
```http request
GET /calculate?salary=720000&days=21

GET /calculate_by_date?salary=600000&vacationStart=2024-06-05&vacationEnd=2024-06-19
```