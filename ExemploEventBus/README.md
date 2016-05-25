EventBus Lib, Comunicação Entre Entidades Android





Opa, blz?

Nesse vídeo mostro como criar comunicação interna em sua APP Android utilizando a lib EventBus, sem necessidade de interfaces como Parcelable e Serializable e sem necessidade de utilizar controles de Threads quando essas são distintas. A lib EventBus além de ser consistente e rápida padroniza a forma de comunicação entre as entidades de sua APP, não há necessidade de métodos / listeners distintos somente porque ao invés de estar utilizando uma comunicação Activity to Activity sua APP está com uma comunicação Fragment to Activity e Fragment to Service, os métodos podem ser exatamente os mesmos.

Algo que pode parecer desvantagem na lib, porém não problemas na falta dessa feature, é a não inclusão de um método de resposter ao Publisher, porém como mostrado no vídeo é tranquilo fazer com que um Subscriber seja também um Publisher e virse-versa. Fique atento quanto ao uso do registerSticky() e postStick(), mesmo que você não venha a utilizá-los é importante entender que não são a mesma coisa que os métodos register() e post() mesmo tendo quase que o exato mesmo comportamento. Mas é isso, a lib EventBus é um excelente alternativa ante ao usode BroadcastReceivers e Intents onde muitas vezes impleca também na utilização das interfaces Parcelable e Serializable, sem mais delongas vou deixar você assistir ao vídeo.

Obs. : Com novo computador e sem programa de edição de vídeo ainda instalado algumas partes tem um dog chorando, mas não atrapalha o entendimento da lib.

O link para download do projeto s encontra logo abaixo no post.

Se links das páginas apresentadas no vídeo:

Página de download da lib EventBus (para o pessoal do Eclipse essa é uma página important)

http://greenrobot.github.io/EventBus/

Página da lib EventBus no GitHub

https://github.com/greenrobot/EventBus

Página HowTo da lib EventBus no GitHub

Vlw