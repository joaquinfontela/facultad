files = ["agrimensura.csv", "alimentos.csv", "civil.csv",
         "electrica.csv", "electronica.csv", "industrial.csv", "informatica.csv",
         "mecanica.csv", "naval.csv", "petroleo.csv", "quimica.csv", "sistema.csv"]

for name in files:
    with open(name, "r") as f:
        lines = []
        for line in f:
            lines.append(",".join(line.split(',')[-4:]))
        for line in lines:
            print(line)
