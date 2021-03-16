# PrisonOptimizer
Po wielu sukcesach gospodarczych i nieustającego, dumnego trwania na mapach Europy i Świata, Polska postanowiła poprawić stan systemu penitencjarnego. Program PrisonOptimizer ma  na  celu  pomóc  członkom polskiej grupy do zadań specjalnych w opracowaniu algorytmu wizualizacji optymalnych wersji zakładu penitencjarnego. 

## Działanie
Program implementuje algorytm genetyczny, aby znaleźć optymalny projekt zakładu.

Elementy uwzględnione w projektowaniu zakładów, to:
* oświetlenie (musi pokrywać cały zakład);
* cele dla osadzonych;
* pokój monitorowania (dla strażników Służby Więziennej);
* kącik sanitarny dla strażników Służby Więziennej;
* kamery monitorujące cele i korytarze (muszą obejmować cały zakład);
* okna w celach i drzwi do cel;
* droga ewakuacyjna (od każdej celi do wejścia musi istnieć droga).

### Funkcja przystosowania
Poszczególne elementy mają swój koszt. Program optymalizuje projekt zakładu, aby koszt całego projektu był jak najmniejszy. Oprócz tego strażnicy Służby Więziennej powinnie mieć możliwie najkrótszą drogę do każdej celi (gdyby zaszła potrzebanagłej interwencji).


Implementacja i działanie programu omówione są w specyfikacjach.

Wizualizacja GUI ze specyfikacji funkcjonalnej:

![image](https://user-images.githubusercontent.com/46055596/89960542-9b03f680-dc3f-11ea-91d3-bae522e404eb.png)

*W repo brakuje GUI*
