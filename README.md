# Втора лабораториска задача по предметот Софтверско Инженерство

## Стефан Ивановски 196068

### Control Flow Graph
![CFG](https://raw.githubusercontent.com/limepixl/SI_lab2_196068/main/CFD.png)

### Цикломатска комплексност
цикломатскаКомплексност = бројРабови - бројТемиња + 2*поврзаниКомпоненти

C = 25 - 20 + 2*1 = 5 + 2 = 7

### Тест случаи според критериумот Multiple Condition

Се гледаат гранките каде што имаме повеќе од еден услов.

Инструкција:  
37 `if (hr < 0 || hr > 24)`

| Комбинација | Тест случај | Branch | Test case |
| ----------- | ----------- | ------ | --------- |
| TF | hr = -1 | 33.2 -> (34, 35, 36) | Time(-1, 0, 0) |
| FT | hr = 25 | 33.2 -> 45 | Time(25, 0, 0) |
| FF | hr = 0 | 33.2 -> 45 | Time(0, 0, 0) |

Инструкција:  
46 `if (min < 0 || min > 59)`
| Комбинација | Тест случај | Branch | Test case |
| ----------- | ----------- | ------ | --------- |
| TF | min = -1 | 46 -> 47 | Time(0, -1, 0) |
| FT | min = 60 | 46 -> 47 | Time(0, 60, 0) |
| FF | min = 0 | 46 -> 49 | Time(0, 0, 0) |

Инструкција:
49 `if (sec >= 0 && sec <= 59)`
| Комбинација | Тест случај | Branch | Test case |
| ----------- | ----------- | ------ | --------- |
| TT | sec = 1 | 49 -> 50 | Time(0, 0, 0) |
| TF | sec = 60 | 49 -> 52 | Time(0, 0, 60) |
| FT | sec = -1 | 49 -> 52 | Time(0, 0, -1) |

Инструкција:
55 `if (hr == 24 && min == 0 && sec == 0)`
| Комбинација | Тест случај | Branch | Test case |
| ----------- | ----------- | ------ | --------- |
| TTT | hr = 24, min = 0, sec = 0 | 55 -> 56 | Time(24, 0, 0) |
| TTF | hr = 24, min = 0, sec = 1 | 55 -> 59 | Time(24, 0, 1) |
| TFX | hr = 24, min = 1 | 55 -> 59 | Time(24, 1, 0) |

Крајни тест случаи:
- Time(-1, 0, 0)
- Time(25, 0, 0)
- Time(0, 0, 0)
- Time(0, -1, 0)
- Time(0, 60, 0)
- Time(0, 0, 60)
- Time(0, 0, -1)
- Time(24, 0, 0)
- Time(24, 0, 1)
- Time(24, 1, 0)

### Тест случаи според критериумот Every Branch

Се гледаат сите гранки. 

Со било кој тест случај (листа од времиња предадени како аргумент на функцијата) се покриваат гранките: 31-33.1, 33.1-33.2, 33.2-62

Следните тест случаи се покриваат со минимална репрезентација од еден Time објект во листата аргумент, и самиот тест случај е иницијализација на листата.

- Test(-1, 0, 0) ги покрива гранките: 33.2-(34,35,36), (34,35,36)-37, 37-38, 38-39, 39-63
- Test(25, 0, 0) ги покрива гранките: 38-42, 42-63
- Test(1, -1, 0) ги покрива гранките: 37-45, 45-46, 46-47, 47-63
- Test(1, 0, 0) ги покрива гранките: 46-49, 49-50, 50-33.3, 33.3-33.2
- Test(1, 0, -1) ги покрива гранките: 49-52, 52-63
- Test(24, 0, 0) ги покрива гранките: 45-55, 55-56, 56-33.3
- Test(24, 1, 0) ги покрива гранките: 55-59, 59-63 

### Објаснување на напишаните unit tests

Одбраните Unit тестови погоре ги напишав така што кај тие кои требаше да тестираат за настанат исклучок, користев `assertThrows` за дали настанатиот исклучок е од тип RuntimeException, и потоа проверка за дали пораката при исклучокот е бараната порака користејќи `assertEquals`. 

Кај тест случаите што требаше да вратат валидно време, тестирав со `assertEquals` во споредба со листа чиј единствен елемент е времето кое треба да се тестира.
