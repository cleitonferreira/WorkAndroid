JobScheduler API no Android, Entendendo e Utilizando





Opa, blz?

Nesse v�deo apresento uma nova forma de executar tarefas no background Android, nesse caso utilizando a JobScheduler API. JobScheduler API faz parte do Project Volta que foi inserido no Android 5 (Lollipop ou API 21) com o intuito de trabalhar de forma mais eficiente os recursos para evitar o consumo exagerado da bateria do device. Com o JobScheduler API n�o precisamos mais de criar l�gicas com o AlarmManager, Service e BroadcastReceiver para sempre ter o AlarmManager rodando ou de implementar um caminh�o de c�digo com o SyncAdapter quando o objetivo � apenas executar tarefas no background (o SyncAdapter, Service, AlarmManager e BroadcastReceiver fazem mais do que isso, logo n�o estou informando o n�o uso mais dessas tecnologias!). Apesar das in�meras vantagens na utiliza��o do JobScheduler ante ao uso dos m�todos anteriores, n�s n�o temos controle de quando ser� executado o nosso job que foi enviado ao schedule, apenas sabemos que ele ser� executado uma �nica vez dentro do intervalo setado ou no m�todo setPeriodic(), ou no m�todo setBackoffCriteria(), ou no m�todo setOverrideDeadline().

Segundo o site AndroidPolice ainda n�o h� a lib de suporte para as vers�o anteriores a API 21 do Android, por�m � prevista j� a inclus�o da lib de suporte (como aconteceu com o ActionBarCompat e o SherlockActionBar). No v�deo mostro que h� a lib JobSchedulerCompat que nos permite utilizar o JobScheduler a partir da API 10, por�m segundo o pr�prio site da API n�o � recomendado utilizar em modo de produ��o (liberada na Google Play Store) devido a ainda n�o ter sido feitos testes mais rigorosos e consequentemente a corre��o de alguns bugs. No v�deo mostro que o m�todo setRequiresDeviceIdle() da lib de suporte est� bugado quando setado com o valor "true", por�m n�o, me equivoquei, na verdade esse m�todo funcionou quando rodando no device real, provavelmente deve ser algum problema quando no emulador. Mas enfim, sem mais delongas vou deix�-lo assistir ao v�deo.

Obs. : Se estava esperando o v�deo Parte 4 da s�rie sobre o Location API, esse v�deo foi feito tamb�m por que ser� parte do v�deo 4 onde falaremos de treking com o Location API em um JobScheduler.

O link para download do projeto se encontra logo abaixo no post.

Segue links de v�deos que ajudam a complementar o entendimento do v�deo a cima que utiliza outras entidades al�m do JobScheduler API:

EventBus Lib, Comunica��o Entre Entidades Android

AsyncTask no Android, Acesso a Thread Principal de Forma Otimizada

Segue links apresentados no v�deo:

P�gina sobre o JobScheduler no site AndroidPolice

http://www.androidpolice.com/2014/07/01/android-l-spotlight-jobscheduler-conserves-battery-life-letting-apps-know-run-background-tasks/

P�gina da classe JobScheduler no site documenta��o do Android

https://developer.android.com/reference/android/app/job/JobScheduler.html

P�gina da classe JobService no site documenta��o do Android

https://developer.android.com/reference/android/app/job/JobService.html

P�gina da classe JobInfo no site documenta��o do Android

https://developer.android.com/reference/android/app/job/JobInfo.html

P�gina da classe JobInfo.Builder no site documenta��o do Android

https://developer.android.com/reference/android/app/job/JobInfo.Builder.html

P�gina da classe ComponentName no site documenta��o do Android

http://developer.android.com/reference/android/content/ComponentName.html

P�gina de implementa��o do JobScheduler no site documenta��o do Android

https://developer.android.com/samples/JobScheduler/index.html

Sess�o sobre o Project Volte -> JobScheduler no site documenta��o do Android

https://developer.android.com/about/versions/android-5.0.html#Power

P�gina da lib de suporte JobSchedulercompat no GitHub

https://github.com/evant/JobSchedulerCompat

Vlw