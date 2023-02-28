PGDMP     $    :                {         	   advocacia    13.8 (Debian 13.8-0+deb11u1)    15.2 (Debian 15.2-1) E    ,           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            -           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            .           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            /           1262    24639 	   advocacia    DATABASE     u   CREATE DATABASE advocacia WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'pt_BR.UTF-8';
    DROP DATABASE advocacia;
                fabricio    false                        2615    2200    public    SCHEMA     2   -- *not* creating schema, since initdb creates it
 2   -- *not* dropping schema, since initdb creates it
                postgres    false            0           0    0    SCHEMA public    ACL     Q   REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   postgres    false    4            �            1259    24831    Arquivo    TABLE     �   CREATE TABLE public."Arquivo" (
    cod integer NOT NULL,
    codproc integer NOT NULL,
    nome text NOT NULL,
    local text NOT NULL
);
    DROP TABLE public."Arquivo";
       public         heap    fabricio    false    4            �            1259    24732 
   Associacao    TABLE     r   CREATE TABLE public."Associacao" (
    cpfcliente character varying(11) NOT NULL,
    codproc integer NOT NULL
);
     DROP TABLE public."Associacao";
       public         heap    fabricio    false    4            �            1259    24687 
   Atribuicao    TABLE     `   CREATE TABLE public."Atribuicao" (
    usuario text NOT NULL,
    codtarefa integer NOT NULL
);
     DROP TABLE public."Atribuicao";
       public         heap    fabricio    false    4            �            1259    24708    Cliente    TABLE     �   CREATE TABLE public."Cliente" (
    nome text,
    dtnasc date,
    ender text,
    prof text,
    rg character varying(7),
    cpf character varying(11) NOT NULL
);
    DROP TABLE public."Cliente";
       public         heap    fabricio    false    4            �            1259    24724    Comentarios    TABLE     ]   CREATE TABLE public."Comentarios" (
    codproc integer NOT NULL,
    texto text NOT NULL
);
 !   DROP TABLE public."Comentarios";
       public         heap    fabricio    false    4            �            1259    24666 
   Legislacao    TABLE     X   CREATE TABLE public."Legislacao" (
    cod integer NOT NULL,
    texto text NOT NULL
);
     DROP TABLE public."Legislacao";
       public         heap    fabricio    false    4            �            1259    24716    Leglinks    TABLE     X   CREATE TABLE public."Leglinks" (
    legcod integer NOT NULL,
    link text NOT NULL
);
    DROP TABLE public."Leglinks";
       public         heap    fabricio    false    4            �            1259    24695 	   Movimenta    TABLE     \   CREATE TABLE public."Movimenta" (
    usuario text NOT NULL,
    codarq integer NOT NULL
);
    DROP TABLE public."Movimenta";
       public         heap    postgres    false    4            �            1259    24742    Movimentacao    TABLE     �   CREATE TABLE public."Movimentacao" (
    dthora timestamp without time zone NOT NULL,
    valor double precision,
    "desc" text
);
 "   DROP TABLE public."Movimentacao";
       public         heap    fabricio    false    4            �            1259    24674    Processo    TABLE     w   CREATE TABLE public."Processo" (
    cod integer NOT NULL,
    tipo text NOT NULL,
    status text,
    orcmnt text
);
    DROP TABLE public."Processo";
       public         heap    fabricio    false    4            �            1259    24703 
   Referencia    TABLE     `   CREATE TABLE public."Referencia" (
    codleg integer NOT NULL,
    codproc integer NOT NULL
);
     DROP TABLE public."Referencia";
       public         heap    fabricio    false    4            �            1259    24648    Tarefa    TABLE     s   CREATE TABLE public."Tarefa" (
    id integer NOT NULL,
    "desc" text NOT NULL,
    dtin date,
    dtenc date
);
    DROP TABLE public."Tarefa";
       public         heap    fabricio    false    4            �            1259    24799 	   Telefones    TABLE     {   CREATE TABLE public."Telefones" (
    cpfcliente character varying(11) NOT NULL,
    num character varying(20) NOT NULL
);
    DROP TABLE public."Telefones";
       public         heap    postgres    false    4            �            1259    24682 	   Transacao    TABLE     �   CREATE TABLE public."Transacao" (
    dthora timestamp without time zone NOT NULL,
    codproc integer,
    cpfcliente character varying(11)
);
    DROP TABLE public."Transacao";
       public         heap    fabricio    false    4            �            1259    24640    Usuario    TABLE     �   CREATE TABLE public."Usuario" (
    login text NOT NULL,
    senha text NOT NULL,
    nome text,
    email text,
    nivel text NOT NULL,
    telefone character varying(20)
);
    DROP TABLE public."Usuario";
       public         heap    fabricio    false    4            )          0    24831    Arquivo 
   TABLE DATA           >   COPY public."Arquivo" (cod, codproc, nome, local) FROM stdin;
    public          fabricio    false    214   �P       &          0    24732 
   Associacao 
   TABLE DATA           ;   COPY public."Associacao" (cpfcliente, codproc) FROM stdin;
    public          fabricio    false    211   �P                  0    24687 
   Atribuicao 
   TABLE DATA           :   COPY public."Atribuicao" (usuario, codtarefa) FROM stdin;
    public          fabricio    false    205   �P       #          0    24708    Cliente 
   TABLE DATA           G   COPY public."Cliente" (nome, dtnasc, ender, prof, rg, cpf) FROM stdin;
    public          fabricio    false    208   �P       %          0    24724    Comentarios 
   TABLE DATA           7   COPY public."Comentarios" (codproc, texto) FROM stdin;
    public          fabricio    false    210   Q                 0    24666 
   Legislacao 
   TABLE DATA           2   COPY public."Legislacao" (cod, texto) FROM stdin;
    public          fabricio    false    202   3Q       $          0    24716    Leglinks 
   TABLE DATA           2   COPY public."Leglinks" (legcod, link) FROM stdin;
    public          fabricio    false    209   PQ       !          0    24695 	   Movimenta 
   TABLE DATA           6   COPY public."Movimenta" (usuario, codarq) FROM stdin;
    public          postgres    false    206   mQ       '          0    24742    Movimentacao 
   TABLE DATA           ?   COPY public."Movimentacao" (dthora, valor, "desc") FROM stdin;
    public          fabricio    false    212   �Q                 0    24674    Processo 
   TABLE DATA           ?   COPY public."Processo" (cod, tipo, status, orcmnt) FROM stdin;
    public          fabricio    false    203   �Q       "          0    24703 
   Referencia 
   TABLE DATA           7   COPY public."Referencia" (codleg, codproc) FROM stdin;
    public          fabricio    false    207   �Q                 0    24648    Tarefa 
   TABLE DATA           ;   COPY public."Tarefa" (id, "desc", dtin, dtenc) FROM stdin;
    public          fabricio    false    201   �Q       (          0    24799 	   Telefones 
   TABLE DATA           6   COPY public."Telefones" (cpfcliente, num) FROM stdin;
    public          postgres    false    213   �Q                 0    24682 	   Transacao 
   TABLE DATA           B   COPY public."Transacao" (dthora, codproc, cpfcliente) FROM stdin;
    public          fabricio    false    204   R                 0    24640    Usuario 
   TABLE DATA           O   COPY public."Usuario" (login, senha, nome, email, nivel, telefone) FROM stdin;
    public          fabricio    false    200   8R       k           2606    24673    Legislacao Legislacao_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public."Legislacao"
    ADD CONSTRAINT "Legislacao_pkey" PRIMARY KEY (cod);
 H   ALTER TABLE ONLY public."Legislacao" DROP CONSTRAINT "Legislacao_pkey";
       public            fabricio    false    202            m           2606    24681    Processo Processo_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public."Processo"
    ADD CONSTRAINT "Processo_pkey" PRIMARY KEY (cod);
 D   ALTER TABLE ONLY public."Processo" DROP CONSTRAINT "Processo_pkey";
       public            fabricio    false    203            i           2606    24655    Tarefa Tarefa_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public."Tarefa"
    ADD CONSTRAINT "Tarefa_pkey" PRIMARY KEY (id);
 @   ALTER TABLE ONLY public."Tarefa" DROP CONSTRAINT "Tarefa_pkey";
       public            fabricio    false    201            g           2606    24665    Usuario Usuario_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public."Usuario"
    ADD CONSTRAINT "Usuario_pkey" PRIMARY KEY (login);
 B   ALTER TABLE ONLY public."Usuario" DROP CONSTRAINT "Usuario_pkey";
       public            fabricio    false    200            �           2606    24854    Arquivo arquivo_cod_codproc_key 
   CONSTRAINT     d   ALTER TABLE ONLY public."Arquivo"
    ADD CONSTRAINT arquivo_cod_codproc_key UNIQUE (cod, codproc);
 K   ALTER TABLE ONLY public."Arquivo" DROP CONSTRAINT arquivo_cod_codproc_key;
       public            fabricio    false    214    214            �           2606    24898    Arquivo arquivo_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public."Arquivo"
    ADD CONSTRAINT arquivo_pkey PRIMARY KEY (cod);
 @   ALTER TABLE ONLY public."Arquivo" DROP CONSTRAINT arquivo_pkey;
       public            fabricio    false    214            �           2606    24736    Associacao associacao_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY public."Associacao"
    ADD CONSTRAINT associacao_pkey PRIMARY KEY (cpfcliente, codproc);
 F   ALTER TABLE ONLY public."Associacao" DROP CONSTRAINT associacao_pkey;
       public            fabricio    false    211    211            q           2606    24694    Atribuicao atribuicao_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public."Atribuicao"
    ADD CONSTRAINT atribuicao_pkey PRIMARY KEY (codtarefa, usuario);
 F   ALTER TABLE ONLY public."Atribuicao" DROP CONSTRAINT atribuicao_pkey;
       public            fabricio    false    205    205            w           2606    24715    Cliente cliente_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public."Cliente"
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (cpf);
 @   ALTER TABLE ONLY public."Cliente" DROP CONSTRAINT cliente_pkey;
       public            fabricio    false    208            }           2606    24911    Comentarios comentarios_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public."Comentarios"
    ADD CONSTRAINT comentarios_pkey PRIMARY KEY (texto);
 H   ALTER TABLE ONLY public."Comentarios" DROP CONSTRAINT comentarios_pkey;
       public            fabricio    false    210                       2606    24788 !   Comentarios comentarios_texto_key 
   CONSTRAINT     _   ALTER TABLE ONLY public."Comentarios"
    ADD CONSTRAINT comentarios_texto_key UNIQUE (texto);
 M   ALTER TABLE ONLY public."Comentarios" DROP CONSTRAINT comentarios_texto_key;
       public            fabricio    false    210            y           2606    24771    Leglinks leglinks_link_key 
   CONSTRAINT     W   ALTER TABLE ONLY public."Leglinks"
    ADD CONSTRAINT leglinks_link_key UNIQUE (link);
 F   ALTER TABLE ONLY public."Leglinks" DROP CONSTRAINT leglinks_link_key;
       public            fabricio    false    209            {           2606    24909    Leglinks leglinks_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public."Leglinks"
    ADD CONSTRAINT leglinks_pkey PRIMARY KEY (link);
 B   ALTER TABLE ONLY public."Leglinks" DROP CONSTRAINT leglinks_pkey;
       public            fabricio    false    209            s           2606    24900    Movimenta movimenta_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public."Movimenta"
    ADD CONSTRAINT movimenta_pkey PRIMARY KEY (usuario, codarq);
 D   ALTER TABLE ONLY public."Movimenta" DROP CONSTRAINT movimenta_pkey;
       public            postgres    false    206    206            �           2606    24887    Movimentacao movimentacao_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public."Movimentacao"
    ADD CONSTRAINT movimentacao_pkey PRIMARY KEY (dthora);
 J   ALTER TABLE ONLY public."Movimentacao" DROP CONSTRAINT movimentacao_pkey;
       public            fabricio    false    212            u           2606    24707    Referencia referencia_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public."Referencia"
    ADD CONSTRAINT referencia_pkey PRIMARY KEY (codleg, codproc);
 F   ALTER TABLE ONLY public."Referencia" DROP CONSTRAINT referencia_pkey;
       public            fabricio    false    207    207            �           2606    24907    Telefones telefones_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public."Telefones"
    ADD CONSTRAINT telefones_pkey PRIMARY KEY (num);
 D   ALTER TABLE ONLY public."Telefones" DROP CONSTRAINT telefones_pkey;
       public            postgres    false    213            o           2606    24885    Transacao transacao_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public."Transacao"
    ADD CONSTRAINT transacao_pkey PRIMARY KEY (dthora);
 D   ALTER TABLE ONLY public."Transacao" DROP CONSTRAINT transacao_pkey;
       public            fabricio    false    204            �           2606    24839    Arquivo arquivo_codproc_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Arquivo"
    ADD CONSTRAINT arquivo_codproc_fkey FOREIGN KEY (codproc) REFERENCES public."Processo"(cod);
 H   ALTER TABLE ONLY public."Arquivo" DROP CONSTRAINT arquivo_codproc_fkey;
       public          fabricio    false    2925    214    203            �           2606    24794 "   Associacao associacao_codproc_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Associacao"
    ADD CONSTRAINT associacao_codproc_fkey FOREIGN KEY (codproc) REFERENCES public."Processo"(cod) NOT VALID;
 N   ALTER TABLE ONLY public."Associacao" DROP CONSTRAINT associacao_codproc_fkey;
       public          fabricio    false    2925    211    203            �           2606    24789 %   Associacao associacao_cpfcliente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Associacao"
    ADD CONSTRAINT associacao_cpfcliente_fkey FOREIGN KEY (cpfcliente) REFERENCES public."Cliente"(cpf) NOT VALID;
 Q   ALTER TABLE ONLY public."Associacao" DROP CONSTRAINT associacao_cpfcliente_fkey;
       public          fabricio    false    208    211    2935            �           2606    24755 $   Atribuicao atribuicao_codtarefa_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Atribuicao"
    ADD CONSTRAINT atribuicao_codtarefa_fkey FOREIGN KEY (codtarefa) REFERENCES public."Tarefa"(id) NOT VALID;
 P   ALTER TABLE ONLY public."Atribuicao" DROP CONSTRAINT atribuicao_codtarefa_fkey;
       public          fabricio    false    2921    201    205            �           2606    24782 $   Comentarios comentarios_codproc_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Comentarios"
    ADD CONSTRAINT comentarios_codproc_fkey FOREIGN KEY (codproc) REFERENCES public."Processo"(cod) NOT VALID;
 P   ALTER TABLE ONLY public."Comentarios" DROP CONSTRAINT comentarios_codproc_fkey;
       public          fabricio    false    2925    210    203            �           2606    24765    Leglinks leglinks_legcod_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Leglinks"
    ADD CONSTRAINT leglinks_legcod_fkey FOREIGN KEY (legcod) REFERENCES public."Legislacao"(cod) NOT VALID;
 I   ALTER TABLE ONLY public."Leglinks" DROP CONSTRAINT leglinks_legcod_fkey;
       public          fabricio    false    209    202    2923            �           2606    24901    Movimenta movimenta_codarq_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Movimenta"
    ADD CONSTRAINT movimenta_codarq_fkey FOREIGN KEY (codarq) REFERENCES public."Arquivo"(cod) NOT VALID;
 K   ALTER TABLE ONLY public."Movimenta" DROP CONSTRAINT movimenta_codarq_fkey;
       public          postgres    false    214    2953    206            �           2606    24760     Movimenta movimenta_usuario_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Movimenta"
    ADD CONSTRAINT movimenta_usuario_fkey FOREIGN KEY (usuario) REFERENCES public."Usuario"(login) NOT VALID;
 L   ALTER TABLE ONLY public."Movimenta" DROP CONSTRAINT movimenta_usuario_fkey;
       public          postgres    false    2919    200    206            �           2606    24772 !   Referencia referencia_codleg_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Referencia"
    ADD CONSTRAINT referencia_codleg_fkey FOREIGN KEY (codleg) REFERENCES public."Legislacao"(cod) NOT VALID;
 M   ALTER TABLE ONLY public."Referencia" DROP CONSTRAINT referencia_codleg_fkey;
       public          fabricio    false    202    2923    207            �           2606    24777 "   Referencia referencia_codproc_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Referencia"
    ADD CONSTRAINT referencia_codproc_fkey FOREIGN KEY (codproc) REFERENCES public."Processo"(cod) NOT VALID;
 N   ALTER TABLE ONLY public."Referencia" DROP CONSTRAINT referencia_codproc_fkey;
       public          fabricio    false    203    207    2925            �           2606    24806 #   Telefones telefones_cpfcliente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Telefones"
    ADD CONSTRAINT telefones_cpfcliente_fkey FOREIGN KEY (cpfcliente) REFERENCES public."Cliente"(cpf);
 O   ALTER TABLE ONLY public."Telefones" DROP CONSTRAINT telefones_cpfcliente_fkey;
       public          postgres    false    2935    213    208            �           2606    24860 #   Transacao transacao_cpfcliente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Transacao"
    ADD CONSTRAINT transacao_cpfcliente_fkey FOREIGN KEY (cpfcliente) REFERENCES public."Cliente"(cpf) NOT VALID;
 O   ALTER TABLE ONLY public."Transacao" DROP CONSTRAINT transacao_cpfcliente_fkey;
       public          fabricio    false    208    2935    204            �           2606    24888    Transacao transacao_dthora_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Transacao"
    ADD CONSTRAINT transacao_dthora_fkey FOREIGN KEY (dthora) REFERENCES public."Movimentacao"(dthora) NOT VALID;
 K   ALTER TABLE ONLY public."Transacao" DROP CONSTRAINT transacao_dthora_fkey;
       public          fabricio    false    204    212    2947            �           2606    24865    Transacao transacao_proc_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Transacao"
    ADD CONSTRAINT transacao_proc_fkey FOREIGN KEY (codproc) REFERENCES public."Processo"(cod) NOT VALID;
 I   ALTER TABLE ONLY public."Transacao" DROP CONSTRAINT transacao_proc_fkey;
       public          fabricio    false    2925    203    204            �           2606    24750    Atribuicao usuario    FK CONSTRAINT     �   ALTER TABLE ONLY public."Atribuicao"
    ADD CONSTRAINT usuario FOREIGN KEY (usuario) REFERENCES public."Usuario"(login) NOT VALID;
 >   ALTER TABLE ONLY public."Atribuicao" DROP CONSTRAINT usuario;
       public          fabricio    false    2919    200    205            )      x������ � �      &      x������ � �             x������ � �      #   "   x�+I-.I��C C3#C#KK�=... �O�      %      x������ � �            x������ � �      $      x������ � �      !      x������ � �      '      x������ � �            x������ � �      "      x������ � �            x������ � �      (      x������ � �            x������ � �            x������ � �     