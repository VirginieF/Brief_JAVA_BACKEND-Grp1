delete from posts;

INSERT INTO public.posts(id,content, published, tags, title)
    VALUES 
    ('PO-001','Une princesse au palais est heureuse', 'true', '#noblesse', 'Palais'),
    ('PO-002','Princesse Arwa au palais de Tunis', 'true', '#noblesse', 'Tresor'),
    ('PO-003','Madeleine DeSuède est malade', 'true', '#Stockholm', 'Palais Royal'),
    ('PO-004', 'Enfin heureuse sans Albert ', 'true', '#Monaco', 'Princesse Charlène'),
    ('PO-005','La Belle dans le palais de la Bête', 'true', '# le monstre', ' la Bête'),
    ('PO-006','au château de la princesse ', 'true', '#le sorcier', ' la tour d’un château'),
    ('PO-007','La princesse de Galles', 'false', '# un enfer', 'palais de Kensington'),
    ('PO-008',' La rose bleue', 'false', '#', ''),
    ('PO-009','une personne parfaite', 'false', '#un défaut', ' palais '),
    ('PO-010',' le bonheur dune princesse ', 'false', '#sur le Rocher', 'palais');