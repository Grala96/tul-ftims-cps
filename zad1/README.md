# Zadanie 1

Generacja sygnału i szumu

## Typy sygnałów oraz ich parametry

|                                	| A 	| t1 	| d 	| T 	| kw 	| ts 	| f 	| p 	|
|--------------------------------	|:-:	|:--:	|:-:	|:-:	|:--:	|:--:	|:-:	|:-:	|
| UNIFORM_NOISE                  	| X 	|  X 	| X 	|   	|    	|    	|   	|   	|
| GAUSSIAN_NOISE                 	| X 	|  X 	| X 	|   	|    	|    	|   	|   	|
| SINUSOIDAL_SIGNAL              	| X 	|  X 	| X 	| X 	|    	|    	|   	|   	|
| SINUSOIDAL_SIGNAL_HALF_ERECTED 	| X 	|  X 	| X 	| X 	|    	|    	|   	|   	|
| SINUSOIDAL_SIGNAL_ERECTED      	| X 	|  X 	| X 	| X 	|    	|    	|   	|   	|
| RECTANGULAR_SIGNAL             	| X 	|  X 	| X 	| X 	|  X 	|    	|   	|   	|
| SYMMETRICAL_RECTANGULAR_SIGNAL 	| X 	|  X 	| X 	| X 	|  X 	|    	|   	|   	|
| TRIANGULAR_SIGNAL              	| X 	|  X 	| X 	| X 	|  X 	|    	|   	|   	|
| UNIT_JUMP                      	| X 	|  X 	| X 	|   	|    	|  X 	|   	|   	|
| UNIT_PULSE                     	| X 	|  X 	| X 	|   	|    	|  X 	| X 	|   	|
| IMPULSIVE_NOISE                	| X 	|  X 	| X 	|   	|    	|    	| X 	| X 	|

**Oznaczenia:**

* A - amplitude / amplituda
* t1 - startTime
* d - duration
* T - basicPeriod
* kw - fillFactor
* ts / ns - jumpTime
* f - activationTime
* p - probability
