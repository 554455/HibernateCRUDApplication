# Задание
 Необходимо реализовать консольное CRUD приложение, которое взаимодействует с БД и позволяет выполнять все CRUD операции над сущностями:
 
Team(id, name, List<Developer> developers)
 
Developer(id, firstName, lastName, List<Skill> skills)
 
Skill(id, name)
   
**Требования:**
 
  - Все CRUD операции для каждой из сущностей
  
  - Придерживаться подхода MVC
  
  - Для сборки проекта использовать Maven
  
  - Для взаимодействия с БД - Hibernate
  
  - Для конфигурирования Hibernate - аннотации
  
  - Инициализация БД должна быть реализована с помощью flyway
  
  - Сервисный слой приложения должен быть покрыт юнит тестами (junit + mockito)

 
**Технологии:**
 
 Java, MySQL, Hibernate, Maven, Flyway, JUnit, Mockito

 **Инструкция по запуску**
 
1.Скачать приложение

2.Перейти в репозиторий по ссылке https://github.com/554455/HibernateCRUDApplication

3.Кликнуть зеленую кнопку "Clone or Download" в правой верхней части страницы.

4.Распаковать архиватором

5.Открыть проект в intellij idea
 
6.Запустить файлы Liquibase (src/main/resources/db/migration/*)

7.Запустить класс main.java.com.umaraliev.crud.Main

