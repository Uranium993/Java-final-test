INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

INSERT INTO game.team(name, tag) VALUES ("Srbija", "SRB");
INSERT INTO game.team(name, tag) VALUES ("Francuska", "FRA");
INSERT INTO game.team(name, tag) VALUES ("Engleska", "ENG");
INSERT INTO game.team(name, tag) VALUES ("Crna Gora", "MNE");
INSERT INTO game.team(name, tag) VALUES ("Slovenija", "SLO");


INSERT INTO game.player(name, surname, goals, team_id)
VALUES ("djordje", "radanovic", 3, 1);
INSERT INTO game.player(name, surname, goals, team_id)
VALUES ("dejan", "nikolic", 1, 1);
INSERT INTO game.player(name, surname, goals, team_id)
VALUES ("nikola", "mijovic", 4, 1);
INSERT INTO game.player(name, surname, goals, team_id)
VALUES ("stefan", "vujovic", 2, 2);
INSERT INTO game.player(name, surname, goals, team_id)
VALUES ("Jack", "Nelson", 2, 3);



INSERT INTO game.game(teama_id, teamb_id, goal_numaaa, goal_numbbb)
VALUES (1,2, 3,2);
INSERT INTO game.game(teama_id, teamb_id, goal_numaaa, goal_numbbb)
VALUES (3, 4, 1,2);
INSERT INTO game.game(teama_id, teamb_id, goal_numaaa, goal_numbbb)
VALUES (5, 1, 1,1);
INSERT INTO game.game(teama_id, teamb_id, goal_numaaa, goal_numbbb)
VALUES (4, 3, 5,2);
INSERT INTO game.game(teama_id, teamb_id, goal_numaaa, goal_numbbb)
VALUES (2, 3, 3,2);