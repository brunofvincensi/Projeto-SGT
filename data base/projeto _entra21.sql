drop database sgt;

create database sgt;
use sgt;



select * from aluno;

create table turma(
id int not null auto_increment,
horario varchar(100),
periodo varchar(100),
nome varchar (100),
quantidade_aluno int,
curso_id int not null,
professor_id int not null,
cliente_id int,
primary key (id)
);
drop table turma;


create table professor(
id int not null auto_increment,
nome varchar(100),
cpf varchar(100),
capacitacao_professor varchar (200),

primary key (id)
);


create table PrestadorServico(
id int not null auto_increment,
razao_social varchar(100),
nome varchar(100),
cnpj varchar(100),
numero int,
cep varchar(100),
cidade  varchar(100),

primary key (id)
);



create table curso(
id int not null auto_increment,
nome varchar(100),
valor_curso float(10, 2),
regulamentacao varchar(100),
conteudo_programatico varchar(200),
primary key (id)
);


create table cliente(
id int not null auto_increment,
razao_social varchar(100),
nome varchar(100),
cnpj varchar(100),
numero int,
cep varchar(100),
data_cadastro date,
cidade  varchar(100),

primary key (id)
);



create table aluno(
id int not null auto_increment,
nome varchar(100),
cpf varchar(100),
turma_id int not null,

primary key (id)
);


select * from usuario;


select 
t.nome,
a.Nome_Aluno
from aluno_turma a_t
inner join turma t
on t.id = a_t.id_turma
inner join aluno a
on a.id = a_t.id_aluno

where t.nome = 'Java Web Noturno' ;



 -- criação das constraints de chave estrangeira --
 
alter table curso add constraint fk_curso_empresa
foreign key(id_empresa)
references empresa(id)
on delete no action
on update no action;

alter table curso add constraint fk_curso_professor
foreign key(id_professor)
references professor(id)
on delete no action
on update no action;


alter table composicaoValor add constraint fk_composicaoValor_empresa
foreign key(id_empresa)
references empresa(id)
on delete no action
on update no action;


alter table composicaoValor add constraint fk_composicaoValor_curso
foreign key(id_curso)
references curso(id)
on delete no action
on update no action;


alter table professor add constraint fk_professor_empresa
foreign key(id_empresa)
references empresa(id)
on delete no action
on update no action;

alter table curso_turma add constraint fk_curso_turma_curso
foreign key(id_curso)
references curso(id)
on delete no action
on update no action;

alter table curso_turma add constraint fk_curso_turma_turma
foreign key(id_turma)
references turma(id)
on delete no action
on update no action;


alter table aluno_turma add constraint fk_aluno_turma_turma
foreign key(id_turma)
references turma(id)
on delete no action
on update no action;

alter table aluno_turma add constraint fk_aluno_turma_aluno
foreign key(id_aluno)
references aluno(id)
on delete no action
on update no action;