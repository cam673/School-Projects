%Christopher Masferrer
%011894127
%CECS 424

%days the objects were seen
day(tuesday).
day(wednesday).
day(thursday).
day(friday).

%the objects seen
object(balloon).
object(clothesline).
object(frisbee).
object(water_tower).

%solver
solve :-
    %set up variables for each object per person, verify that each are different
    object(BarradaObject), object(GortObject), object(KlatuObject), object(NiktoObject),
    all_different([BarradaObject, GortObject, KlatuObject, NiktoObject]),
    
    %set up variables for each day per person, verify that each are different
    day(BarradaDay), day(GortDay), day(KlatuDay), day(NiktoDay),
    all_different([BarradaDay, GortDay, KlatuDay, NiktoDay]),
    
    %store all the information in an array
    People = [ [ms_barrada, BarradaObject, BarradaDay],
               [ms_gort, GortObject, GortDay],
               [mr_klatu, KlatuObject, KlatuDay],
               [mr_nikto, NiktoObject, NiktoDay] ],
    
    %Enter the various different cases that must be satisfied
    %Case 1a: Mr. Klatu spotted earlier than the one that spotted the Balloon.
    \+ member([mr_klatu, balloon, _], People),
    \+ member([mr_klatu, _, friday], People),
    
    %Case 1b: Mr.Klatu spotted later than the one who spotted the Frisbee.
    \+ member([mr_klatu, _, tuesday], People),
    \+ member([mr_klatu, frisbee, _], People),
    
    %Case 1c: Ms.Gort did not spot the Frisbee.
    \+ member([ms_gort, frisbee, _], People),
    
    %Case 2: Friday sighting made by Ms.Barrada, the one who say the clothesline, or both.
    (   (member([ms_barrada, _, friday], People));
    	(member([_, clothesline, friday], People));
    	(member([ms_barrada, clothesline, friday], People)) ),
    
    %Case 3: Mr.Nikto did not sight on Tuesday.
    \+ member([mr_nikto, _, tuesday], People),
    
    %Case 4: Mr.Klatu did not see the Water Tower.
    \+ member([mr_klatu, water_tower, _], People),
    
    %print the results
    print(ms_gort, GortObject, GortDay),
    print(mr_klatu, KlatuObject, KlatuDay),
    print(mr_nikto, NiktoObject, NiktoDay),
    print(ms_barrada, BarradaObject, BarradaDay).
    
%check if all entries are different
all_different([H | T]) :- member(H, T), !, fail.
all_different([_ | T]) :- all_different(T).
all_different([_]).

%print out results
print(X, Y, Z) :-
    write(X), write(' saw a '), write(Y), write(' on ') , write(Z), write('.'), nl.