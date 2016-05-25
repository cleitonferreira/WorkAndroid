Vendendo Produtos e Inscrições Com Google In-App Billing no Android




Opa, blz?

Nesse vídeo mostro como implementar o In-APP Billing em nossas APPs Android para podermos utilizar a plataforma de pagamento do Google (a mesma utilizada para APPs pagas no Google Play Store) para processar as compras de produtos (o Google sinaliza que somente produtos digitais ou inscrições devem utilizar o In-APP Billing) e inscrições dentro de nossas APPs. A API é bem simples de integrar, é necessário ter já baixado o Google Play Billing Library pelo SDK Manager. O Google na documentação do In-app Billing deixa claro que a API deve ser utilizada para produtos digitais e que o Google somente fornece a descrição e alguns outros dados do produtos / inscrição e a APP é encarregada de fornecer o conteúdo referente a compra realizada.

Como comentado em vídeo, tive problemas para utilizar a versão alfa da APP como versão de teste, logo utilizei a versão de produção que passou sem problemas, depois apenas fiz o reembolso pela página do Google Wallet. É necessário que sua conta de desenvolvedor do Google Play Store esteja com a conta de Comerciante ativada (conta no Google Wallet) que por sinal é bem fácil também de ativar. Fique ligado quanto a configuração necessária no AndroidManifest.xml e com os arquivos que devem estar no projeto de sua, arquivos que devem ser obtidos do exemplo que vem junto ao Google Play Billing Library. No vídeo cometi alguns mistakes, mas um merece maior relevancia que é o uso do método correto para compra de produto e compra de inscrição, para compra de produto utilizamos o método launchPurchaseFlow() para compra de inscrição utilizamos o método launchSubscriptionPurchaseFlow(), ambos podem ter exatamente os mesmos parâmetros.

Apesar de a integração ser fácil e o controle na página do Google Wallet ser fácil também o Google fica com aproximadamente 30% do valor de compra realizado. Nesse caso você tem de pesar para ver se é jogo colocar o Billing em sua APP ou quebrar a cabeça com uma outra API de pagamento que cobre uma taxa menor. Então é isso, vou evitar mais delongas e deixar você assistir ao vídeo.

O link para download do projeto está logo abaixo no post.

Segue links de vídeos que podem lhe ajudar a complementar o conteúdo desse vídeo:

Assinando Uma APP Android e Publicando na Play Store

Application Class no Android, Entendendo e Utilizando

Segue link das páginas apresentadas no vídeo:

Página de start do Google In-app Billing no site do Android

https://developer.android.com/google/play/billing/index.html

Página de instalação do plugin do ADT no Eclipse

http://developer.android.com/sdk/installing/installing-adt.html


iinappbillingservice cannot be resolved android studio

http://stackoverflow.com/questions/17836234/how-can-i-add-the-aidl-file-to-android-studio-from-the-in-app-billing-example

Vlw