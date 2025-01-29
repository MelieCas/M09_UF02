1.

    Perque el programa es queda encallat amb tots els threads al wait esperant que s'alliberin els recursus per poder utilitzarl-los.

2.
    Codi modificat per el 70% de fer reserva: 
    (image.png)

    Execucio amb 70% de fer reserva:
    (image-1.png)

    Codi modificat per el 30% de fer reserva:
    (image-2.png)

    Execucio amb 30% de fer reserva:
    (image-3.png)

3.
    Perque hi ha que mantenir seguiment dels Threads de assistent que tenen la reserva ja que son ells els que tenen que fer el notify als Threads que estan al wait.
