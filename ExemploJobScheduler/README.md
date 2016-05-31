JobScheduler API no Android, Entendendo e Utilizando





Opa, blz?

Nesse vídeo apresento uma nova forma de executar tarefas no background Android, nesse caso utilizando a JobScheduler API. JobScheduler API faz parte do Project Volta que foi inserido no Android 5 (Lollipop ou API 21) com o intuito de trabalhar de forma mais eficiente os recursos para evitar o consumo exagerado da bateria do device. Com o JobScheduler API não precisamos mais de criar lógicas com o AlarmManager, Service e BroadcastReceiver para sempre ter o AlarmManager rodando ou de implementar um caminhão de código com o SyncAdapter quando o objetivo é apenas executar tarefas no background (o SyncAdapter, Service, AlarmManager e BroadcastReceiver fazem mais do que isso, logo não estou informando o não uso mais dessas tecnologias!). Apesar das inúmeras vantagens na utilização do JobScheduler ante ao uso dos métodos anteriores, nós não temos controle de quando será executado o nosso job que foi enviado ao schedule, apenas sabemos que ele será executado uma única vez dentro do intervalo setado ou no método setPeriodic(), ou no método setBackoffCriteria(), ou no método setOverrideDeadline().

Segundo o site AndroidPolice ainda não há a lib de suporte para as versão anteriores a API 21 do Android, porém é prevista já a inclusão da lib de suporte (como aconteceu com o ActionBarCompat e o SherlockActionBar). No vídeo mostro que há a lib JobSchedulerCompat que nos permite utilizar o JobScheduler a partir da API 10, porém segundo o próprio site da API não é recomendado utilizar em modo de produção (liberada na Google Play Store) devido a ainda não ter sido feitos testes mais rigorosos e consequentemente a correção de alguns bugs. No vídeo mostro que o método setRequiresDeviceIdle() da lib de suporte está bugado quando setado com o valor "true", porém não, me equivoquei, na verdade esse método funcionou quando rodando no device real, provavelmente deve ser algum problema quando no emulador. Mas enfim, sem mais delongas vou deixá-lo assistir ao vídeo.

Obs. : Se estava esperando o vídeo Parte 4 da série sobre o Location API, esse vídeo foi feito também por que será parte do vídeo 4 onde falaremos de treking com o Location API em um JobScheduler.

O link para download do projeto se encontra logo abaixo no post.

Segue links de vídeos que ajudam a complementar o entendimento do vídeo a cima que utiliza outras entidades além do JobScheduler API:

EventBus Lib, Comunicação Entre Entidades Android

AsyncTask no Android, Acesso a Thread Principal de Forma Otimizada

Segue links apresentados no vídeo:

Página sobre o JobScheduler no site AndroidPolice

http://www.androidpolice.com/2014/07/01/android-l-spotlight-jobscheduler-conserves-battery-life-letting-apps-know-run-background-tasks/

Página da classe JobScheduler no site documentação do Android

https://developer.android.com/reference/android/app/job/JobScheduler.html

Página da classe JobService no site documentação do Android

https://developer.android.com/reference/android/app/job/JobService.html

Página da classe JobInfo no site documentação do Android

https://developer.android.com/reference/android/app/job/JobInfo.html

Página da classe JobInfo.Builder no site documentação do Android

https://developer.android.com/reference/android/app/job/JobInfo.Builder.html

Página da classe ComponentName no site documentação do Android

http://developer.android.com/reference/android/content/ComponentName.html

Página de implementação do JobScheduler no site documentação do Android

https://developer.android.com/samples/JobScheduler/index.html

Sessão sobre o Project Volte -> JobScheduler no site documentação do Android

https://developer.android.com/about/versions/android-5.0.html#Power

Página da lib de suporte JobSchedulercompat no GitHub

https://github.com/evant/JobSchedulerCompat

Vlw