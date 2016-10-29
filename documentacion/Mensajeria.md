# Mensajeria
Todos los mensajes del cliente llevan la ip:
```JSON
{
	"IP": {
    	"Direccion":"127.0 .0 .1"
    }
}
```
## Creacion de personajes
Cliente envia la seleccion de una raza y casta de las disponibles
```JSON

{
	"Personaje": {
		"Nombre": "CrimsonBraixen",
        "Accion": {
    	"Nombre":"CreacionPersonaje"
    	},
		"Raza": "Humano",
		"Casta": "Guerrero"
	}
}
```
## Inicio de partida
Servidor envia Mapas disponibles
```JSON
{
	"Mapas": [{
		"Mapa": "Estrella de la muerte"
	}, {
		"Mapa": "Bosque Kokiri"
	}, {
		"Mapa": "Calle Victoria"
	}, {
		"Mapa": "Ruinas"
	}]
}
```
Cliente envia la seleccion del mapa
```JSON

{
	"Accion": {
		"Nombre": "Mover"
	},
	"Mapa": {
		"Nombre": "Estrella de la muerte "
	}
}
```

## Jugadores en el mapa

Servidor envia Posicion inicial a cada cliente conectado
```JSON


{
	"Personaje": {
		"Nombre": "CrimsonBraixen",
		"Accion": {
			"Nombre": "PosicionInicial"
		},
		"Punto": {
			"x": 0,
			"y": 0
		}
	}
}
```
Cliente envia posicion nueva valida al moverse.
```JSON

{
	"Personaje": {
		"Nombre": "CrimsonBraixen",
		"Accion": {
			"Nombre": "Mover"
		},
		"Punto": {
			"x": 2,
			"y": 3
		}
	}
}

```

Servidor envia a todos los demas clientes la posicion de ese personaje
```JSON

{
	"Personaje": {
		"Nombre": "CrimsonBraixen",
		"Accion": {
			"Nombre": "MovimientoDelPersonaje"
		},
		"Punto": {
			"x": 2,
			"y": 3
		}
	}
}

```

### Formacion de alianza
Cliente 1 manda al servidor el  personaje(Cliente 2) que se le envia la solicitud de alianza
```JSON
{
	"Personaje": {
		"Nombre": "CrimsonBraixen",
		"Accion": {
			"Nombre": "InvitarAAlianza"
		},
		"Personaje": {
			"Nombre": "Yamazaki"
		}
	}
}
```

Servidor envia esa solicitud al Cliente 2
```JSON

{
	"Personaje": {
    	"Nombre":"Yamazaki",
		"Accion": {
			"Nombre": "RecibirInvitacion"
		},
		"Personaje": {
			"Nombre": "CrimsonBraixen"
		}
	}
}

```
Cliente 2 envia respuesta:
En caso de ser positivo se forma una nueva alianza
```JSON

{
	"Personaje": {
    	"Nombre":"Yamazaki",
		"Accion": {
			"Nombre": "AceptarInvitacion"
		},
		"Personaje": {
			"Nombre": "CrimsonBraixen"
		}
	}
}
```
Servidor envia dicha alianza a cada integrante de ella.
```JSON
{
	"Personaje": {
    	"Nombre":"Azul",
		"Accion": {
			"Nombre": "UnirAlianza"
		},
		"Alianza": {
			"Nombre": "Kokiri"
		}
	}
}
```

En caso de ser negativo comienza una batalla
```JSON
{
	"Personaje": {
    	"Nombre":"Yamazaki",
		"Accion": {
			"Nombre": "RechazarAlianza"
		},
       "Personaje": {
			"Nombre": "CrimsonBraixen"
		}
	}
}
```

## Batalla
Cliente 1 manda al servidor el enemigo(Cliente 2) y la lista de personajes invocados
```JSON
{
	"Personaje": {
		"Nombre": "CrimsonBraixen",
		"Aliados": [{
			"Personaje": "CrimsonBraixen"
		}, {
			"Personaje": "Ho-Oh"
		}, {
			"Personaje": "Lugia"
		}, {
			"Personaje": "Groudon"
		}, {
			"Personaje": "Kyogre"
		}, {
			"Personaje": "Missigno"
		}]
	}
}
```
Servidor envia la notificacion de batalla al cliente 2
```JSON
{
	"Personaje": {
		"Nombre": "Yamazaki",
		"Accion": {
			"Nombre": "RecibirBatalla"
		},
		"Personaje": {
			"Nombre": "CrimsonBraixen"
		}
	}
}
```

Cliente 2 le indica la lista de sus aliados invocados
```JSON

{
	"Personaje": {
		"Nombre": "Yamazaki",
		"Aliados": [{
			"Personaje": "Yamazaki"
		}, {
			"Personaje": "Hanamichi"
		}, {
			"Personaje": "Mario"
		}, {
			"Personaje": "Roberto"
		}
		}]
	}
}

```
Servidor notifica a todos los clientes involucrados
```JSON
{
	"Personaje": {
		"Nombre": "Hanamichi",
		"Aliados": [{
			"Personaje": "Yamazaki"
		}, {
			"Personaje": "Hanamichi"
		}, {
			"Personaje": "Mario"
		}, {
			"Personaje": "Roberto"
		}],
		"Enemigos": [{
			"Personaje": "CrimsonBraixen"
		}, {
			"Personaje": "Ho-Oh"
		}, {
			"Personaje": "Lugia"
		}, {
			"Personaje": "Groudon"
		}, {
			"Personaje": "Kyogre"
		}, {
			"Personaje": "Missigno"
		}],
		"Accion": {
			"Nombre": "RechazarAlianza"
		}
	}
}
```

Servidor envia el turno al cliente
```JSON
{
	"Personaje": {
		"Nombre": "Hanamichi",
        "Accion": {
			"Nombre": "ObtenerTurno"
		}
}

```

Cliente envia el ataque y el destinatario
```JSON
{
	"Personaje": {
		"Nombre": "Hanamichi",
        "Accion": {
			"Nombre": "Atacar"
		},
        "Personaje": {
        	"Nombre": "Missigno"
        }
}
O bien:
{
	"Personaje": {
		"Nombre": "Hanamichi",
        "Accion": {
			"Nombre": "Hechizar"
		},
        "Hechizo": {
        	"Nombre": "Empujon de Fuerza"
        },
        "Personaje": {
        	"Nombre": "Missigno"
        }
}

```

Servidor envia dicho ataque.
```JSON
{

	"Personaje": {
		"Nombre": "CrimsonBraixen",
        "Accion": {
			"Nombre": "NotificarAtaque"
		},
        "PersonajeAtacante": {
        	"Nombre": "Hanamichi"
        },
         "PersonajeAtacado": {
        	"Nombre": "Missigno"
        }
}
O bien:
{
	"Personaje": {
		"Nombre": "Hanamichi",
        "Accion": {
			"Nombre": "NotificarHechizo"
		},
        "Hechizo": {
        	"Nombre": "Empujon de Fuerza"
        },
       "PersonajeAtacante": {
        	"Nombre": "Hanamichi"
        },
         "PersonajeAtacado": {
        	"Nombre": "Missigno"
        }
}

```
Servidor informa que un personaje murio:
```JSON
{
	"Personaje": {
		"Nombre": "CrimsonBraixen",
		"Accion": {
			"Nombre": "NotificarMuerte"
		},
		"Personaje": {
			"Nombre": "Missigno"
		}
	}
}
```

Al finalizar servidor informa ganador
```JSON
{
	"Personaje": {
		"Nombre": "CrimsonBraixen",
		"Accion": {
			"Nombre": "NotificarHechizo"
		},
		"Alianza": {
			"Nombre": "Kokiri"
		}
	}
}
```
Perdedores envian items al servidor
```JSON
{
	"Personaje": {
		"Nombre": "Yamazaki",
		"Accion": {
			"Nombre": "EntregarItem"
		},
		"Item": {
			"Nombre": "EspadaKokiri"
		}
	}
}
```
Servidor manda items a los ganadores
```JSON
{
	"Personaje": {
		"Nombre": "CrimsonBraixen",
		"Accion": {
			"Nombre": "NotificacionDeItemsDisponibles"
		},
		"Items": [{
			"Item": "EspadaKokiri"
		}, {
			"Item": "Espadaoorgoroth"
		}, {
			"Item": "VaritaMissigno"
		}]
	}
}

```

Ganadores notifica el item recogido
```JSON
{
	"Personaje": {
		"Nombre": "CrimsonBraixen",
		"Accion": {
			"Nombre": "RecogerItem"
		},
		"Item": {
			"Nombre": "EspadaKokiri"
		}
	}
}
```

Servidor informa que el item fue recogido al resto.
```JSON
{
	"Personaje": {
		"Nombre": "Groudon",
		"Accion": {
			"Nombre": "NotificarItemRecogido"
		},
		"Personaje": {
			"Nombre": "CrimsonBraixen",
			"Item": {
				"Nombre": "EspadaKokiri"
			}
		}
	}
}

```
Personaje informa que quiere abandonar la batalla
```JSON
{
	"Personaje": {
		"Nombre": "Roberto",
		"Accion": {
			"Nombre": "EscaparDeBatalla"
		}
	}
}
```
Servidor informa a los demas que el cliente 1 abandonó la batalla
```JSON
{
	"Personaje": {
		"Nombre": "CrimsonBraixen",
		"Accion": {
			"Nombre": "NotificarEscapeDeBatalla"
		},
        "Personaje": {
			"Nombre": "Roberto"
         }
	}
}
```


Servidor envia la expieriencia ganada en la batalla a cada personaje.
```JSON
{
	"Personaje": {
		"Nombre": "CrimsonBraixen",
		"Accion": {
			"Nombre": "ObtenerExperiencia"
		},
		"Experiencia": 200
	}
}
```
