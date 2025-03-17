# Тысячи курсов

### Стек:
- Android SDK 26+ (android 8)
- Kotlin
- Retrofit
- Kotlin corouties
- Dagger/hilt
- MVVM
- Android XML
- ViewBinding
- Single Activity Architecture
- Clean Architecture + Vertical Slice (UI)
- Datastore (вместо SharedPrefs)

Core модуль является базой для всех feature. Он хранит общие зависимости, а также хранит навигацию.
Feature модули лишь пользуются общим API для навигации, которые реализованы в core.

ПОЖАЛУЙСТА, УБЕДИТЕСЬ ПЕРЕД ЗАПУСКОМ, ЧТО В BUILD.GRADLE.KTS У МОДУЛЯ APP СТОИТ ВЕРНЫЕ API ENDPOINT
В DEBUG И RELEASE МОДАХ! ЭКРАН HOME (отвечающий за курсы) МОЖЕТ НЕ ПОКАЗЫВАТЬСЯ И ВЫЛЕТАТЬ, ЕСЛИ
НЕ УКАЗАТЬ ЗНАЧЕНИЯ.

Благодарю за прочтение и проверку ТЗ :)
