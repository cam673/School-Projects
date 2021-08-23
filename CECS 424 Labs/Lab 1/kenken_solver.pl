:- use_module(library(clpfd)).

%addition clause
sum_list([], 0).
sum_list([H | T], S) :- sum_list(T, S2), S #= S2 + H.

%subtraction clause
sub_list(0,0,0).
sub_list(X, Y, S) :- X #> Y, S #= X - Y.
sub_list(X, Y, S) :- X #< Y, S #= Y - X.
sub_list(X, Y, S) :- X #= Y, S #= 0.

%multiplication clause
product_list([], 1).
product_list([H], H).
product_list([H | T], S) :- product_list(T, S2), S #= S2 * H.

%division clause
div_list(0,0,0).
div_list(X, Y, S) :- X #> Y, S #= X // Y.
div_list(X, Y, S) :- X #< Y, S #= Y // X.
div_list(X, Y, S) :- X #= Y, S #= 1.

%cell_values clause
cell_values([], _, []).
cell_values([[X, Y]|T], S, Values) :-
    nth0(X, S, Row),
    nth0(Y, Row, V),
    cell_values(T, S, TValues),
    Values = [V|TValues].

%check_constraint id clause
check_constraint(cage(id, Value, [X, Y]), S) :-
    nth0(X, S, Row),
    nth0(Y, Row, Value).

%check_constraint add clause
check_constraint(cage(add, Value, [[X, Y]|T]), S) :-
    cell_values([[X, Y]|T], S, Result),
    sum_list(Result, Value).

%check_constraint sub clause
check_constraint(cage(sub, Value, [[X1, Y1], [X2, Y2]]), S) :-
    nth0(X1, S, Row1),
    nth0(Y1, Row1, V1),
    nth0(X2, S, Row2),
    nth0(Y2, Row2, V2),
    sub_list(V1, V2, Value).

%check_constraint mult clause
check_constraint(cage(mult, Value, [[X, Y]|T]), S) :-
    cell_values([[X, Y]|T], S, Result),
    product_list(Result, Value).

%check_constraint div clause
check_constraint(cage(div, Value, [[X1, Y1], [X2, Y2]]), S) :-
    nth0(X1, S, Row1),
    nth0(Y1, Row1, V1),
    nth0(X2, S, Row2),
    nth0(Y2, Row2, V2),
    div_list(V1, V2, Value).

%check_cages clause
check_cages([], S).
check_cages([H|T], S) :-
    check_constraint(H, S),
    check_cages(T, S).

%solve clause
solve([], S).
solve([H|T], S) :-
    %1. S must have 6 rows
    length(S, 6),
    %2. Each row in S must be length 6
    S = [A, B, C, D, E, F],
    length(A,6),
    length(B,6),
    length(C,6),
    length(D,6),
    length(E,6),
    length(F,6),
    %3. Each row in S must only contain values from 1 to 6
    append(S, Values),
	Values ins 1..6,
    %4. The entries in S must satisfy the cages of the puzzle
    check_cages([H|T], S),
    %5. Each row in S must contain all distinct values
    maplist(all_different, S),
    %6. Each column in S must contain all distinct values
    transpose(S, Cols),
	maplist(all_different, Cols),
	
	maplist(label, S).