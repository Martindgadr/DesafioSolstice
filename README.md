# DesafioSolstice
Solstice Challenge

El desafío requiere desarrollar una aplicación que muestre una lista de contactos y al seleccionar uno de ellos muestre el detalle del mismo.
Dentro del detalle se debe poder seleccionar como favorito o quitar el atributo de favorito según opción del usuario, actualizando así la lista principal de contactos.
El diseño esta basado en lo que pedía el desafío según archivo PDF de referencia.

# Arquitectura del proyecto

Se desarrollo con arquitectura **MVVM** según lineamientos google y usando el paquete de Architecture Components Android. Utiliza LiveData y Obserbable Pattern.

# Puntos Desarrollados

- **Listado de contactos,** desarrollado con android recycler view multi items, multi holder.
- **Llamado al servicio solsctice,** Utilizando la libreria Retrofit by square.
- **Detalle del contacto con Custom View,** Se utilizo una custom view para mostrar o quitar items del detalle.
- **Inyeccion de vistas,** Utilizando la libreria ButterKnife.
- **Best practice & clean code,** Se intento optimizar en lo maximo el codigo y utilando las buenas practicas.

# Aclaraciones y mejoras

Por cuestiones de tiempo y estar en medio de las fiestas, se realizo el código con un sort de lista en código y no utilizando una SortedList en el adaptador. Una mejora podría ser eso como así también cambiar el objeto modificado solo si tuvo un cambio.
