/*
 * DML for data inserted into the 'state', 'sports', 'team' and 'players' tables 
 */
-- STATE DML
INSERT INTO training731.state(state_name) VALUES('California');
INSERT INTO training731.state(state_name) VALUES('Texas');

-- SPORTS DML
INSERT INTO training731.sports(sport_name) VALUES('football');
INSERT INTO training731.sports(sport_name) VALUES('basketball');

-- TEAM DML
INSERT INTO training731.team VALUES(DEFAULT,'broncos',1,1); 
INSERT INTO training731.team VALUES(DEFAULT,'49ers',2,1);
INSERT INTO training731.team VALUES(DEFAULT,'cowboys',3,1);
INSERT INTO training731.team VALUES(DEFAULT,'nuggets',1,2);
INSERT INTO training731.team VALUES(DEFAULT,'lakers',2,2);
INSERT INTO training731.team VALUES(DEFAULT,'spurs',3,2);
INSERT INTO training731.team VALUES(1004,'newbies',3,2);

-- PLAYERS DML
/*
 * You can add Dates using a variety of methods, for example:
 * 		'YYYY-MM-DD' : i.e. 2000-01-10
 * 		'Month DD, YYYY' : i.e. January 10, 2000
 * 		'YYYY-Mon-DD' : i.e. 2000-Jan-10
 * 		DATE ('<VALUE>')
 * 		TO_DATE('<VALUE>','<Formatting>')
 * Alternatively, you can use the built-in 'CURRENT_DATE' for the current date
 */
INSERT INTO training731.players VALUES (DEFAULT,1,'Bill Smith',450000,DATE '2000-01-10');
INSERT INTO training731.players VALUES (DEFAULT,1,'Matt Jones',470000,TO_DATE('2000/01/10','YYYY/MM/DD'));
INSERT INTO training731.players VALUES (DEFAULT,1,'Joe Williams',480000,'January 01, 2000');
INSERT INTO training731.players VALUES (DEFAULT,1,'Gary Brown',447500,'2000-Jan-01');

INSERT INTO training731.players VALUES (DEFAULT,2,'Dill Smith',650000,CURRENT_DATE);
INSERT INTO training731.players VALUES (DEFAULT,2,'Pat Jones',660000,CURRENT_DATE);
INSERT INTO training731.players VALUES (DEFAULT,2,'Moe Williams',620000,CURRENT_DATE);
INSERT INTO training731.players VALUES (DEFAULT,2,'Larry Brown',635000,CURRENT_DATE);

INSERT INTO training731.players VALUES (DEFAULT,3,'Hill Smith',700000,CURRENT_DATE);
INSERT INTO training731.players VALUES (DEFAULT,3,'Cat Jones',710000,CURRENT_DATE);
INSERT INTO training731.players VALUES (DEFAULT,3,'Poe Williams',690000,CURRENT_DATE);
INSERT INTO training731.players VALUES (DEFAULT,3,'Perry Brown',730000,CURRENT_DATE);

INSERT INTO training731.players VALUES (DEFAULT,4,'Phil Smith',550000,CURRENT_DATE);
INSERT INTO training731.players VALUES (DEFAULT,4,'Kat Jones',590000,CURRENT_DATE);
INSERT INTO training731.players VALUES (DEFAULT,4,'Whoa Williams',540000,CURRENT_DATE);
INSERT INTO training731.players VALUES (DEFAULT,4,'Terri Brown',620000,CURRENT_DATE);

INSERT INTO training731.players VALUES (DEFAULT,5,'Will Smith',580000,CURRENT_DATE);
INSERT INTO training731.players VALUES (DEFAULT,5,'Yatt Jones',550000,CURRENT_DATE);
INSERT INTO training731.players VALUES (DEFAULT,5,'Slo-Mo Williams',540000,CURRENT_DATE);
INSERT INTO training731.players VALUES (DEFAULT,5,'Jerri Brown',580000,CURRENT_DATE);

INSERT INTO training731.players VALUES (DEFAULT,6,'Nill Smith',600000,CURRENT_DATE);
INSERT INTO training731.players VALUES (DEFAULT,6,'Fatt Jones',580000,CURRENT_DATE);
INSERT INTO training731.players VALUES (DEFAULT,6,'Romo Williams',590000,CURRENT_DATE);
INSERT INTO training731.players VALUES (DEFAULT,6,'Scary Brown',610000,CURRENT_DATE);