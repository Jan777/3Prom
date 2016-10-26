# Historias de usuario
## Personaje
1. Como jugador quiero que el personaje pueda recoger items para aumentar mis stats
    - **Criterio de aceptación**: dado un personaje, cuando gane una batalla entonces  puede recoger items.

2. Como jugador quiero que el personaje pueda subir de nivel dada una experiencia requerida para aumentar mis stats
    - **Criterio de aceptación**: Dado un personaje,cuando alcance la experiencia requerida, entonces subirá de nivel

3. Como jugador quiero elegir una raza para mis personaje
     - **Criterio de aceptación**: Dado un personaje, este podrá ser de las siguientes razas: Humano, Orco, Personaje de Star Wars, Personaje de Undertale, Pokemon o Personaje de Kingdom Hearts.

4. Como jugador, quiero derrotar enemigos para subir experiencia
    - **Criterio de aceptación**: Dado un personaje y un enemigo cuando el personaje derrote al enemigo, este subirá tantos puntos de experiencia como puntos de salud tenga el enemigo derrotado.

5. Como jugador, quiero aliarme a otros jugadores para ganar mas batallas
    - **Criterio de aceptación**: Dado dos personajes cuando se alien, ambos formaran una nueva alianza(si no poseían otra) o combinarán sus respectivas alianzas en una sola.

6. Como jugador, quiero poder abandonar una alianza luego de un tiempo de haberme unido
    - **Criterio de aceptación**: Dado un personaje, este podrá abandonar la alianza luego de 1 minuto de haberse unido.

7. Como jugador, quiero adquirir habilidades de destreza, fuerza e inteligencia para afectar a mis puntos de ataque, magia y defensa
    - **Criterio de aceptación**:Dado un personaje que sube de nivel, puede desbloquear habilidades de destreza,fuerza e inteligencia, que modifiquen sus stats.

8. Como jugador, quiero poder elegir la casta de mi personaje.
    - **Criterio de aceptación**: Dado un jugador, este podrá elegir una casta según la raza anteriormente elegida.

9. Como jugador, quiero encontrarme con otros jugadores en el mismo mundo para aliarse a ellos o combatir contra ellos.
    - **Criterio de aceptación**: Dado un jugador que encuentra otro jugador, podrá elegir invitarlo a formar una alianza o desafiarlo en un combate

10. Como jugador, quiero combatir junto con mi alianza contra alianzas enemigas para ganar de experiencia mas rapidamente
    - **Criterio de aceptación**: Dado un personaje y su alianza,cuando rete a otro personaje de otra alianza entonces comienza un combate entre jugadores que estén dentro de un radio de acción.

11. Como jugador, quiero tener un inventario para guardar armas
    - **Criterio de aceptación**: Dado un personaje, este tendrá un inventario en el que podrá guardar un item de cada tipo.

12. Como personaje, quiero atacar a otro personaje, reduciendo mi energia, para disminuir su salud.
	- **Criterio de aceptación**: Dado un personaje y un enemigo, cuando el personaje ataca al enemigo, entonces este reduce su salud y el personaje reduce su energia.

13. Como personaje, quiero atacar a un enemigo para derrotarlo.
	- **Criterio de aceptación**: Dado un personaje y un enemigo, cuando el personaje ataca al enemigo y la salud de este llega a 0, entonces este muere.

14.  Como personaje, quiero ser curado para recuperar mi salud maxima.
	- **Criterio de aceptación**: Dado un personaje, cuando su salud es menor a la maxima y es curado, entonces su salud vuelve a ser la maxima.

15. Como personaje, quiero ser energizado para recuperar mi energia maxima.
	- **Criterio de aceptación**: Dado un personaje, cuando su energia es menor a la maxima y es energizado, entonces su energia vuelve a ser la maxima.

16. Como personaje, quiero disponer de energia para poder atacar.
	- **Criterio de aceptación**: Dado un personaje, cuando su energia es mayor al valor del ataque, entonces puede atacar.

17. Como personaje, quiero disponer de defensa para resistir a los ataques.
	- **Criterio de aceptación**: Dado un personaje y un enemigo, cuando el primero es atacado, entonces los puntos de ataque del segundo se restaran con los puntos de ataque del personaje para calcular el daño.

18. Como personaje, quiero ganar puntos de habilidad para obtener nuevas habilidades.
	- **Criterio de aceptación**: Dado un personaje, cuando suba de nivel, ganara un punto de habilidad.

19. Como personaje, quiero tener habilidades de fuerza, para aumentar mis stats.
	- **Criterio de aceptación**: Dado un personaje, cuando obtenga una habilidad, entonces aumentaran sus stats dependiendo de dicha habilidad.

20. Como personaje, quiero poseer hechizos para sacar ventaja en los combates.
	- **Criterio de aceptación**: Dado un personaje, cuando este entre en combate, podra utilizar diferentes hechizos que pueden dañar, curar, o aumentar stats.

21. Como jugador quiero que al subir de nivel, cada personaje de una casta  aumente mas los stats en los que es fuerte.
    - **Criterio de aceptación**: Dado un personaje de una determinada raza y casta, al subir de nivel aumenta 5 puntos en los stats en los que es fuerte y 3 punto en el resto

## Razas

### ++Humano++
11. Como Humano, quiero poder elegir una casta para mi personaje.
    - **Criterio de aceptación**: Dado un Humano, este podrá ser de las siguientes castas: Mago, Guerrero,  Tanque.

12. Como Humano , quiero que cada vez que suba de nivel, los stats aumentan los stats de manera equitativa.
    - **Criterio de aceptación**: Dado un humano, cuando aumente de nivel, los todos los stats aumentan en 1.

#### Guerrero
44. Como GuerreroHumano, quiero que tenga más ataque que el resto de los stats
    - **Criterio de aceptación**: Dado un GuerreroHumano, sus puntos deben ser: SALUD=100, ENERGIA=100, MAGIA=3, ATAQUE=20, DEFENSA=3 y VELOCIDAD=3.

#### Mago

42. Como MagoHumano, quiero que tenga más salud que el resto de los stats
    - **Criterio de aceptación**: Dado un MagoHumano, sus puntos deben ser: SALUD=100, ENERGIA=100, MAGIA=20, ATAQUE=3, DEFENSA=3 y VELOCIDAD=5.

#### Tanque
39. Como TanqueHumano, quiero que tenga más salud y defensa que el resto de los stats
    - **Criterio de aceptación**: Dado un TanqueHumano, sus puntos deben ser: SALUD=100, ENERGIA=100, MAGIA=5, ATAQUE=2, DEFENSA=15 y VELOCIDAD=2.


### Orco
13. Como Orco, quiero poder elegir una casta para mi personaje.
    - **Criterio de aceptación**: Dado un Orco, este podrá ser de las siguientes castas: Mago, Guerrero, Tanque.

14. Como Orco, cada vez que este ataca, aumenta su ataque.
    - **Criterio de aceptación**: Dado un Orco,cuando ataca, entonces aumenta su ataque  en 10 puntos.

#### Guerrero

43. Como GuerreroOrco, quiero que tenga más ataque que el resto de los stats
    - **Criterio de aceptación**: Dado un GuerreroOrco, sus puntos deben ser: SALUD=100, ENERGIA=100, MAGIA=3, ATAQUE=20, DEFENSA=4 y VELOCIDAD=3.

#### Mago

41. Como MagoOrco, quiero que tenga más salud que el resto de los stats
    - **Criterio de aceptación**: Dado un MagoOrco, sus puntos deben ser: SALUD=100, ENERGIA=100, MAGIA=20, ATAQUE=4, DEFENSA=4 y VELOCIDAD=3.

#### Tanque

40. Como TanqueOrco, quiero que tenga más salud que el resto de los stats
    - **Criterio de aceptación**: Dado un TanqueOrco, sus puntos deben ser: SALUD=100, ENERGIA=100, MAGIA=5, ATAQUE=2, DEFENSA=15 y VELOCIDAD=2.

### ++Star Wars++
15. Como Personaje de Star Wars, quiero poder elegir una casta para mi personaje.
    - **Criterio de aceptación**:Dado un Personaje de Star Wars, este podrá ser Wookie, Jedi, o droide.

#### Jedi

16. Como Jedi, cada vez que suba de nivel, los stats aumentan los stats basandose en energia y magia, y menos en ataque.
    - **Criterio de aceptación**: Dado un Jedis, cada vez que aumente de nivel, aumenta magia y energia  en 10, 2 en ataque y 5 en los demas stats.

19. Como Jedi, cada vez que este ataca, aumenta su magia.
    - **Criterio de aceptación**: Dado un Jedi,Cada vez que ataca aumenta su magia en 2 puntos.

38. Como Jedi, quiero que tenga más puntos de magia que ataque, defensa y velocidad
    - **Criterio de aceptación**: Dado un jedi, sus puntos deben ser: SALUD=50, ENERGIA=100, ATAQUE=8,DEFENSA=8,VELOCIDAD=8 y MAGIA=20.

#### Wookie
17. Como Wookie, cada vez que suba de nivel, los stats aumentan los stats basandose en ataque, menos en velocidad.
    - **Criterio de aceptación**: Dado un Jedis, cada vez que aumente de nivel, aumenta ataque  en 10, 2 en velocidad y 5 en los demas stats.

20. Como Wookie, cada vez que este ataca, aumenta su ataque pero disminuye su defensa.
    - **Criterio de aceptación**: Dado un Wookie,Cada vez que ataca aumenta su ataque en 5 puntos y disminuye su defensa en 2 puntos.

36. Como Wookie, quiero que tenga más puntos de ataque y defensa que el resto
    - **Criterio de aceptación**: Criterio de Aceptación: Los puntos de wookie deben ser SALUD=50,ENERGIA=100,ATAQUE=15, DEFENSA=15, VELOCIDAD=5 y MAGIA=5

#### Droide
18. Como Droide, cada vez que suba de nivel, los stats aumentan los stats basandose en velocidad, menos en defensa.
    - **Criterio de aceptación**: Dado un Jedis, cada vez que aumente de nivel, aumenta velocidad  en 10, 2 en defensa y 5 en los demas stats.

21. Como Droide, cada vez que este ataca, aumenta su velocidad.
    - **Criterio de aceptación**: Dado un Droide,Cada vez que ataca aumenta su velocidad en 2 puntos.

37. Como Droide, quiero que mi personaje tenga mas velocidad que el resto
    - **Criterio de aceptación**: Los puntos de doide deben ser SALUD=50, ENERGIA=100, ATAQUE=7,DEFENSA=7,VELOCIDAD=17 y MAGIA=7.


### ++Undertale++
22. Como personaje de UnderTale quiero poder elegir una casta para mi personaje.
    - **Criterio de aceptación**: Dado un Personaje de UnderTale, este SOLO podrá ser el personaje Chara;

23. Como Personaje de UnderTale, cada vez que este ataca, aumenta su ataque y energia.
    - **Criterio de aceptación**: Dado un Personaje de Undertale,Cada vez que ataca aumenta su ataque y su energia  en 1 punto

#### Chara
29. Como el Personaje Chara, deseo que tenga más ataque que el resto de los stats.
    - **Criterio de aceptación**: Los Stats de Chara deben ser: SALUD=50, ENERGIA=100, ATAQUE=15, MAGIA=5,VELOCIDAD=10 y DEFENSA=10.

### ++Pokemon++
24. Como Pokemon, quiero poder elegir una casta para mi personaje.
    - **Criterio de aceptación**: Dado un Personaje de Pokemon, este podrá ser de Fuego, Agua o Planta.

26. Como personaje de pokemon, cada vez que este ataca aumenta su energía.
    - **Criterio de aceptación**: Dado un Personaje de Pokemon ,Cada vez que ataca aumenta su energía en 10 puntos

#### Pokemon de Fuego
30. Como Pokemon de Fuego deseo que tenga más magia que el resto.
    - **Criterio de aceptación**: Los puntos del Pokemon de fuego deben ser: SALUD=50, ENERGIA=100, ATAQUE=10 DEFENSA:10 VELOCIDAD=5 y MAGIA=15.

#### Pokemon de Agua
31. Como Pokemon de agua, deseo que los stats sean destacados en ataque y defensa pero debil en Velocidad
    - **Criterio de aceptación**: Criterio de Aceptación: Los puntos del pokemon de agua deben ser: SALUD=50, ENERGIA=100, ATAQUE=12,DEFENSA=12,VELOCIDAD=5 y MAGIA=10.

#### Pokemon de Planta

32. Como Pokemon de Planta , deseo que se destaque en magia y defensa, pero muy débil en velocidad..
    - **Criterio de aceptación**: Criterio de Aceptación: Los puntos del pokemon de planta deben ser:  SALUD=50, ENERGIA=100, ATAQUE=10,DEFENSA=12,VELOCIDAD=5 y MAGIA=12.

### ++Kingdom Hearts++
27. Como Personaje de Kingdom Hearts , quiero poder elegir una casta para mi personaje
    - **Criterio de aceptación**: Dado un personaje de Kingdom Hearts , este podrá ser Riku, Roxas y Sora.

28. Como personaje de Kingdom Hearts, cada vez que este ataca aumenta su defensa.
    - **Criterio de aceptación**: Dado un Personaje de Kingdom Hearts,Cada vez que ataca aumenta su defensa en 12.5% de su defensa base.

#### Riku

33. Como Riku, quiero que tenga más puntos de magia y ataque que defensa.
    - **Criterio de aceptación**: Los puntos de Riku deben ser: SALUD=50, ENERGIA=100, ATAQUE=12,DEFENSA=5,VELOCIDAD=10 y MAGIA=10.

#### Sora

34. Como Sora, quiero que sus puntos se destaquen en Magia en vez del resto
    - **Criterio de aceptación**: Criterio de Aceptación: Los puntos de Sora deben ser SALUD=50, ENERGIA=100, ATAQUE=7,DEFENSA=7,VELOCIDAD=7 y MAGIA=17.

#### Roxas

35. Como Roxas, quiero que sus puntos  se destaquen en ataque en vez del resto
    - **Criterio de aceptación**: Criterio de Aceptación: Los puntos de Roxas deben ser: SALUD=50, ENERGIA=100, ATAQUE=17,DEFENSA=7,VELOCIDAD=7 y MAGIA=7.



##Personaje Equipado
39. Como personaje equipado quiero poder equiparme un ítem de cada tipo.
    - **Criterio de aceptación**: dado un personaje se pueden equipar distintos tipos de armas a la vez.

40. Como personaje equipado quiero poder guardar un ítem de cada tipo en un inventario.
    - **Criterio de aceptación**: Dado un personaje y varios items, se puede guardar uno de cada tipo en el inventario.

41. Como personaje equipado quiero poder obtener más puntos de ataque a partir de los ítems que tengo equipados.
    - **Criterio de aceptación**:Dado un personaje y un ítem que aumenta ataque, este stat se verá potenciado por el ítem.

42. Como personaje equipado quiero poder obtener más puntos de defensa a partir de los ítems que tengo equipados.
    - **Criterio de aceptación**:Criterio de aceptación: Dado un personaje y un ítem que aumenta defensa, este stat se verá potenciado por el ítem.

43. Como personaje equipado quiero poder obtener más puntos de magia a partir de los ítems que tengo equipados.
    - **Criterio de aceptación**: Dado un personaje y un ítem que aumenta magia, este stat se verá potenciado por el ítem.

44. Como personaje equipado quiero poder obtener mis puntos de velocidad a partir de los ítems que tengo equipados.
    - **Criterio de aceptación**: Dado un personaje y un ítem que aumenta velocidad, este stat se verá potenciado por el ítem.














