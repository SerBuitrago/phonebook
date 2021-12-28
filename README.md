
# Phonebook

Permite simular una agenda telefonica, donde cada usuario pueden agregar numeros telefonicos y 
asignarle un nombre a este. La finalidad es realizar una **api-rest** con la base de datos 
no relacional **mongodb** y ademas realizarle pruebas unitarias con **unit test** y el 
framework **mockito**.


## Rutas
`Host:` http://localhost:8080

### Contacto

- Consultar por el **id**
  | Metodo | Ruta             |
  |--------|------------------|
  | GET    |  /{id}           |
  | GET    |  /find/id/{id}   |

- Consultar por el **numero telefonico** y el **numero telefonico** del **usuario**
  | Metodo | Ruta                                                 |
  |--------|------------------------------------------------------|
  | GET    |  /find/phone/{phoneContact}/user/phone/{phoneUser}   |

- Listar contactos
  | Metodo | Ruta     |
  |--------|----------|
  | GET    |    /     |
  | GET    |   /all   |

- Consultar por el **numero telefonico**
  | Metodo | Ruta                       |
  |--------|----------------------------|
  | GET    |  /all/find/phone/{phone}   |

- Consultar por el **numero telefonico** del **usuario**
  | Metodo | Ruta                            |
  |--------|---------------------------------|
  | GET    |  /all/find/user/phone/{phone}   |

- Registrar contacto
  | Metodo | Ruta                    |
  |--------|-------------------------|
  | POST   | /                       |

  **JSON**
  ```sh
  {
    "name" : String,
    "phone" : String,
    "user" : {
        "name" : String,
        "phone" : String,
    },
  }
  ```
- Actualizar contacto
  | Metodo | Ruta                    |
  |--------|-------------------------|
  | PUT    | /                       |

  **JSON**
  ```sh
  {
    "name" : String,
    "phone" : String,
    "user" : {
        "name" : String,
        "phone" : String,
    },
  }
  ```

- Eliminar contacto por su **id**
  | Metodo    | Ruta     |
  |-----------|----------|
  | DELETE    |  /{id}   |