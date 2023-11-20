# Реестр фермеров с использованием CMS Liferay

### Используемый стек:

- Язык - Java;
- JDK - 1.7 версия;
- Система сборки - Maven 3.8.8;
- СУБД - PostgreSQL 9.6.24;
- Фреймворк приложений - Liferay 6.2.5


### О приложении

Реестр фермеров, предназначен для управления информацией о фермерских хозяйствах и соответствующих районах. Приложение позволяет добавлять, редактировать и архивировать районы/фермы. Для ферм присутствует возможность восстанавливать данные из архива. А также присутствует возможность фильтрации данных по: названию организации, ИНН, району и дате регистрации, статусу архивности.

### Модель данных

Атрибуты районов:
 - название (обязательное)
 - код района
 - статус архивности (да/нет)

Атрибуты фермеров:
 - название организации (обязательное, фильтр)
 - организационно-правовая форма (ЮР, ИП, ФЛ)
 - ИНН (обязательное, фильтр)
 - КПП
 - ОГРН
 - район регистрации (связь с районом) (фильтр)
 - районы посевных полей (множественный выбор, связь с районом)
 - дата регистрации (фильтр)
 - статус архивности (да/нет) (фильтр)

### Технические моменты

Для каждого реестра реализован свой портлет в рамках одного приложения. 

Вывод информации в виде таблицы реализован с помощью компонента <liferay-ui:search-container />.

Добавлена валидация полей согласно ТЗ.


