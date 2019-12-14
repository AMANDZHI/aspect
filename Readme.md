Join point точки наблюдения 

pointcut - срез, запрос точек присоединения Join point-ов
advice - набор инструкций выполняемых на срезах pointcut

advice бывают типов
before
after
after returning после возврата значения из функции
after throwing в случае exception
after finally - после finally
around перед и после или вообще обойти вызов

Аспект это модуль в котором собраны Pointcut и advice