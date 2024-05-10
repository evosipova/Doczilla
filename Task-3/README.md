# Task-3

### Описание
Создано приложение для управления задачами, выполненное на основе архитектуры "клиент-сервер". Серверная часть написана на C#, а клиентская — на HTML и JavaScript с использованием jQuery. Основное назначение приложения — управление списком задач посредством REST API.

### Состав приложения:

- База данных:

  Используется внутренняя коллекция List<TaskEntity>, эмулирующая базу данных на время разработки.
  
- Серверная часть:

  Внедрена политика AllowAll для разрешения междоменных запросов.

  Управление задачами: Контроллер TodosController предоставляет методы для работы с задачами.

  Сервис Swagger.
  
- Клиентская часть:

  HTML + JavaScript: Веб-интерфейс на HTML и JavaScript.
  
### Основные функции интерфейса:

- Отображение всех задач и задач за текущую дату.
- Календарь для выбора даты.
- Модальное окно с подробным описанием задачи.
- Отображение выполненных и невыполненных задач.

  
### Инструкция по запуску:

1) Запустите сервер. Откройте проект в Visual Studio или другой IDE.
2) Соберите и запустите приложение.
3) апустите клиентскую часть, открыв файл index.html в любом веб-браузере.


### Итоговый вид проекта:

<img width="1011" alt="image" src="https://github.com/evosipova/Doczilla/assets/90273831/4b19baff-2fd2-4bc7-b3fc-f4bcbe71aaf1">

<img width="1027" alt="image" src="https://github.com/evosipova/Doczilla/assets/90273831/b4af0555-4a7b-41bb-9801-07935dcccbc9">

<img width="1007" alt="image" src="https://github.com/evosipova/Doczilla/assets/90273831/4ea927a0-dc37-40bd-80a2-73a9d1f65ee3">

<img width="1009" alt="image" src="https://github.com/evosipova/Doczilla/assets/90273831/594d9a22-1345-469c-919f-2aae7496f660">

<img width="921" alt="image" src="https://github.com/evosipova/Doczilla/assets/90273831/3ada9770-a9f6-4111-bc7e-26b92aa2a2ab">


### Отладка:

<img width="1281" alt="image" src="https://github.com/evosipova/Doczilla/assets/90273831/c8e804d1-1d3f-4a5d-90d7-4fff489e9372">

<img width="1205" alt="image" src="https://github.com/evosipova/Doczilla/assets/90273831/f382fd49-fcc7-4834-9f2a-11b1fb0fdd03">

<img width="1105" alt="image" src="https://github.com/evosipova/Doczilla/assets/90273831/22e1dc62-2823-49fb-971b-c67e867e84d9">

<img width="1147" alt="image" src="https://github.com/evosipova/Doczilla/assets/90273831/5eb93619-f502-470b-ab24-55daefa74212">

