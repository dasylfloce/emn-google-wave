developpers preview
will be open sourced
créé par les 2 mecs de google maps

wiki google code

nice API
-> ils attendent qu'on dev la dessus

#### Product ####
-40 years ago: email, done without experience of media
so how would be email if it was invented today? -> wave
-une wave est publique sur un serveur, ça n'est pas de la messagerie privée
-demo built on GWT
-speeds up the conversation avoiding "john doe is typing"
-si un pote rejoint la wave, il a toute la conversation
-ça bugge un peu
-mode reponse privée du coup comme un mail normal
-structure d'arbre, droits par branche
-drag'n drop, gestion des miniatures: B a les photos de A avant que A ait fini d'uploader (requires "Gears")
Cliquer glisser avec choix façon kde: est-ce qu'on veut mettre un lien/embed...
API : include waves in html pages
-il veut que les objets soient stockés qu'une fois (par ex d'une wave a l'autre)
-bot: bloggy (permet les commentaires du blog vers la wave sans etre invité directement)
-orkut peut creer/utiliser les waves
-interaction avec les mobile devices
-on peut edit les messages des autres comme sur un wiki
-qd on met a jour la wave (ex: rename) le blog se met à jour tout seul
-plus besoin d'hesiter entre faire un mail et proposer un wiki pour que les gens discutent ou m'aident, je peux envoyer une wave et c réglé
-Pas besoin d'etape de creation de document, on lance une wave, apres ça peut tourner en document plus tard
-On peut aussi faire le contraire: partir sur un truc qui ressemble a un wiki et des discutions s'intègrent en plein milieu avec le slider pour l'historique (on peut preciser si on veut les modifs d'un utilisateur/paragraphe)
-on peut masquer des discutions qui ont eu lieu dans le document, on peut faire des copies pour exporter un travail
-support des langues/encodage nikel
-on peut taper a plusieurs en meme temps en temps reel, petit code de couleur, ex pour prendre des notes a plusieurs pendant une conf
-100% GWT, plus a se soucier des soucis d'implementation, mais que du haut niveau
-on peut tagguer les wawes, y compris les waves des autres
-on peut facilement lier des waves dans une autre wave par drag'n drop, c facile
-les recherches se mettent a jour toutes seules si on ajoute du contenu (pas besoin de rafraichir)
-spell checking "spelly" qui tient compte du contexte -> vraiment l'air puissant
-interface pluginable grace aux bots qui participent: ex: searchy
-l'API externe peut presque faire tout ce que l'interne peut faire
-Yes/No/MayBe gadget
-Sudoku a plusieurs
-On peut mettre une googlemap dans le doc, elle se met à jour partout toute seule si on change le point,le zoom...
-Il y a les bots, et les extensions des waves: enquetes/Twitter
-on peut utliser wawes a travers un programme qui se sert de l'API sans etre un googlewawe user en utilisant un proxy comme le login twitter
-extension: mise en forme dans les waves qui peuvent etre consultées par des bots: bug tracker maj bugs et respo bug depuis wave

### Protocol ###
tout le monde peut creer son serveur dans son coin et ensuite les echanges sont possibles entre les differents serveurs par federation
-> pas besoin d'etre relié à un serveur de chez google
-> chacun va vers son serveur et les serveurs s'envoient les données
Securité: les private replies sont pas envoyées sur les serveurs qui ne doivent pas y avoir accès

Idee a moi:
on pourrait introduire des waves dans des videos flash par ex...