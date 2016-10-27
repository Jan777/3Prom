# Mensajeria
## Creacion de personajes
Cliente envia la seleccion de una raza y casta de las disponibles
```
{"raza":"Humano","casta":"Guerrero"}
```
## Inicio de partida
Servidor envia Mapas disponibles
```
{"Mapas":[
    {"Mapa":"Estrella de la muerte"},
    {"Mapa":"Bosque Kokiri"},
    {"Mapa":"Calle Victoria"},
    {"Mapa":"Ruinas"}
]}
```
Cliente envia la seleccion del mapa
```
{"Mapa":"Estrella de la muerte"}
```
## Jugadores en el mapa

Servidor envia Posicion inicial a cada cliente conectado
```
{"x":0,"y":0}
```
Cliente envia posicion nueva valida al moverse.
```
{"x":2,"y":3}
```

Servidor envia a todos los demas clientes la posicion de ese personaje
```
{"Personaje":"CrimsonBraixen"}
{"x":2,"y":3}
```

### Formacion de alianza
Cliente 1 manda al servidor el  personaje(Cliente 2) que se le envia la solicitud de alianza
```
{"Personaje":"CrimsonBraixen"}
{"Alianza":"true"}
```
Servidor envia esa solicitud al Cliente 2
```
{"Personaje":"Yamazaki"}
{"Alianza":"true"}
```
Cliente 2 envia respuesta:
En caso de ser positivo se forma una nueva alianza
```
{"Alianza":"true"}
```
Servidor envia dicha alianza a cada integrante de ella.
```
{"Alianza":"true"}
```

En caso de ser negativo comienza una batalla
```
{"Alianza":"false"}
{"Batalla":"true"}
```

## Batalla
Cliente 1 manda al servidor el enemigo(Cliente 2) y la lista de personajes invocados
```
{"Personaje":"Yamazaki"}
{"Aliados":[
	{"Personaje":"CrimsonBraixen"},
	{"Personaje":"Ho-Oh"},
	{"Personaje":"Lugia"},
	{"Personaje":"Groudon"},
	{"Personaje":"Kyogre"},
	{"Personaje":"Missigno"}
]}
```
Servidor envia la notificacion de batalla al cliente 2
```
{"Batalla":"true"}
```

Cliente 2 le indica la lista de sus aliados invocados
```
{"Aliados":[
	{"Personaje":"Yamazaki"},
	{"Personaje":"Hanamichi"},
	{"Personaje":"Mario"},
	{"Personaje":"Roberto"},
]}
```
Servidor notifica a todos los clientes involucrados
```
{"Batalla":"true"}
```

Servidor envia el turno al cliente
```
{"Turno":"true"}
```

Cliente envia el ataque y el destinatario
```
{"Ataque":"atacar"}
{"Personaje":"Groudon"}
```

Servidor envia al resto dicho ataque.
```
{"Ataque":"atacar"}
{"Personaje":"Groudon"}
```

Al finalizar servidor informa ganador
```
{"Ganador":"true"}
```
Perdedores envian items al servidor
```
{"Item":"EspadaKokiri"}
```
Servidor manda items a los ganadores
```
{"Items":[
	{"Item":"EspadaKokiri"},
    {"Item":"Espadaoorgoroth"},
    {"Item":"VaritaMissigno"},
]}
```

Ganadores notifica el item recogido
```
{"Item":"EspadaKokiri"}
```

Servidor informa que el item fue recogido al resto.
```
{"Personaje":"CrimsonBraixen"}
{"Item":"EspadaKokiri"}
```


<!--Falta: Escapar, Muerte del personaje, repartir experiencia-->