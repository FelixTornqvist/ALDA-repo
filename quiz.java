for (Node temp = first; temp != null; temp = temp.next) {
  if (temp.data.equals("söksträng")) {
     return true;
    }
  }
return false;


boolean exists(Node n) {
  if (n == null)
     return false;

  if (n.data.equals("söksträng"))
     return true;

  return exists(n.next);
}

int[] arr;
// Här skapas och initieras arrayen
int i, j, newValue;

for (i = 1; i < arr.length; i++) {
  newValue = arr[i];
  j = i;

  while (j > 0 && arr[j - 1] > newValue) {
    arr[j] = arr[j - 1];
    j--;
  }
  arr[j] = newValue;
}


1. välj ett nummer mellan 1 o 13
2. dra 3 färger av det nummret (4!) Av dessa premutationer spelar ordningen på de tre korten ingen roll så (/3!)
3. dra 2 till nummer
  3.1 dra nummer 1, det finns 38 kort kvar och ett av dem är samma nummer som vi har valt som vi inte vill ha (37 kort att välja mellan alltså)
  3.2 dra nummer 2, du kan välja mellan 36 kort nu

13*(4!/3!)*37*36

Det finns 13 olika nummer i en kortlek, alltså 13 sätt att dra ett av dem.
Att dra tre färger som har det valda numret går att göra på 4! sätt. Men av dessa spelar inte ordningen på korten någon roll, så jag delar 4! med 3!, och får fyra olika händer.
Nu behöver jag dra två kort till för att få en hand om fem kort. Av 52 korten i leken har jag redan dragit tre och har således 49 kort kvar att välja mellan. Men ett av dessa skulle göra min triss till ett fyrtal, så det ger mig 48 kort att välja mellan. Jag drar ett kort av dessa 48. Av de 47 som blivit kvar drar jag ytterligare ett kort.
Detta kan uttryckas 13 * (4!/3!) * 48 * 47




{0},  ∅,        1,        {a, {2}},        0, 
{{0}, ∅}, {{0}, 1}, {{0}, {a, {2}}},      {{0}, 0}
            {∅, 1},       {∅, {2}},       {∅, 0}
                      {1, {a, {2}}},       {1, 0}
                                          {{a, {2}}, 0}

{0},
∅,
1,
{a, {2}},
0, 

{{0}, ∅},
{{0}, 1},
{{0}, {a, {2}}},
{{0}, 0}
{∅, 1},
{∅, {a, {2}},
{∅, 0}
{1, {a, {2}}},
{1, 0}
{{a, {2}}, 0}

{{0}, ∅, 1},
{{0}, 1, {a, {2}}},
{{0}, {a, {2}}},
{{0}, 0, {a, {2}}}

{∅, 1},
{∅, {a, {2}},
{∅, 0}

{1, {a, {2}}},
{1, 0}

{{a, {2}}, 0}




S = 
{{0},
∅,
1,
{a, {2}},
0}


S = {{0},∅, 1, {a, {2}}, 0}


 T = {0, 1, 2, 2, {1}}.
 T = {0, 1, 2, {1}}.


{}
{0}
{1}
{2}
{{1}}
{0, 1}
{0, 2}
{1, 2}
{0, 1, 2}
{0, {1}}
{1, {1}}
{2, {1}}
{1, 2, {1}}
{0, 1, {1}}
{0, 2, {1}}
{0, 1, 2, {1}}