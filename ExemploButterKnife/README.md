ButterKnife Lib, Simplificando Acesso a Views no Android


Opa, blz?

Nesse vídeo apresento a lib ButtlerKnife que simplifica o acesso as views de nossos layouts XML em nossas APPs Android por meio de annotations. Desenvolvida pelo já conhecido Jake Wharton (se utilizou o ActionBarSherlock algum dia sabe quem é ele) a lib ButtlerKnife além de simplificar o acesso as Views nos permite vincular listeners as views sem a necessidade de classes anônimas e implementação de Interfaces. Com os listener temos ainda mais flexibilidade, pois podemos remover o parâmetro de entrada (o default é View) ou já coloca-lo no mesmo tipo da view vinculada, Button, por exemplo. Porém vejo como a principal vantagem na lib ButtlerKnife a padronização de vinculação entre as variaveis de instancia e as views do XML, sem necessidade de cast e de acesso a findViewById(...), como falei no vídeo, podem ter situações em que temos de acessar dezenas de views em uma mesma entidade (situações que considero comum por ter passado por isso mais de uma vez), com a lib conseguimos deixar a vinculação e declaração das variaveis tudo em um lugar somente e então invocar o método ButtlerKnife.inject(...). Como comento no vídeo também, muito provavelmente a APP perde em tempo de processamento, porém a perda deve ser na casa de algumas dezenas de milisegundos, logo não sei se vale a pena quebrarmos a cabeça com esse pequeno tempo de processamento que pode ser perdido ante ao uso da lib ButtlerKnife que melhora em muito a manutenibilidade do código. Então é isso, o vídeo ficou pequeno em relação aos últimos enviados, a lib a ultil, mas esquente a cabeça com ela em momento de refatoração de código se você estiver com a APP em desenvolvimento.

Obs. : Desculpe o dog no background, ainda não podendo editar os vídeos.

O link para download do projeto se encontra logo abaixo no post.

Segue link do post sobre BaseAdapter se ainda não conhecer essa entidade:

Utilizando BaseAdapter Para Personalização Completa da ListView

Segue links das páginas apresentadas no vídeo:

Página do Buttler Knife

http://jakewharton.github.io/butterknife/

Página do Buttler Knife no GitHub

https://github.com/JakeWharton/butterknife

Vlw