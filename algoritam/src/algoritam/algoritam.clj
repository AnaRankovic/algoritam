(ns algoritam.algoritam)

(defn Euclidean [x1 x2 y1 y2]
     (/ 1 (+ 1(Math/sqrt( + (Math/pow 2 (- x1 x2)) (Math/pow 2 (- y1 y2)))))))

//napravi funkciju kojoj prosledjujes 2 imena, a on ti vraca njihove skorove
//prolazi kroz sve filmove i vraca euklida
//Euklidu prosledjujes imena izvodjaca
//vrednosti sumiras i na kraju radis 1/(1 + suma)
//Ako nemaju zajednicke rejtinge vracas 0 -->  ako je neki null
//pravi metode za svaki red u tabeli


from math import sqrt
# Returns a distance-based similarity score for person1 and person2
def sim_distance(prefs,person1,person2):
# Get the list of shared_items
si={}
for item in prefs[person1]:
if item in prefs[person2]:
si[item]=1
# if they have no ratings in common, return 0
if len(si)==0: return 0
# Add up the squares of all the differences
sum_of_squares=sum([pow(prefs[person1][item]-prefs[person2][item],2)
for item in prefs[person1] if item in prefs[person2]])
return 1/(1+sum_of_squares)
This function can be called with two