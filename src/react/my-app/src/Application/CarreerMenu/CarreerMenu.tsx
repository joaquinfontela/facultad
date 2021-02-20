import React from 'react'
import "./CarreerMenu.css"

interface CarreerMenuProps {
    carreerId: number
    onClick: Function
    loggedIn: boolean
}

export default class CarreerMenu extends React.Component<CarreerMenuProps, {}> {

    constructor(props: any) {
        super(props);

        window.onclick = function (event: any) {
            if (!event.target.matches('.dropbtn')) {
                var dropdowns = document.getElementsByClassName("dropdown-content");
                var i;
                for (i = 0; i < dropdowns.length; i++) {
                    var openDropdown = dropdowns[i];
                    if (openDropdown.classList.contains('show')) {
                        openDropdown.classList.remove('show');
                    }
                }
            }
        }
    }

    getCarreerNameButtonList(): JSX.Element[] {
        let i: number;
        var carreerNameDivList: JSX.Element[] = [];
        for (i = 1; i <= 12; i++) {
            const constI: number = i;
            carreerNameDivList.push(<button key={i} onClick={() => { this.props.onClick(constI) }}>{idCarreerMap[i]}</button>);
        }
        return carreerNameDivList;
    }

    render(): JSX.Element {
        if (!this.props.loggedIn) {
            return (<div></div>);
        }
        return (
            <div className="dropdown">
                <button onClick={() => { document.getElementById("myDropdown")?.classList.toggle("show") }} className="dropbtn">{idCarreerMap[this.props.carreerId]}</button>
                <div id="myDropdown" className="dropdown-content">
                    {this.getCarreerNameButtonList()}
                </div>
            </div>
        );
    }
}

const idCarreerMap: any = {
    0: "Escoja una carrera...",
    1: "Ingeniería Civil",
    2: "Ingeniería de Alimentos",
    3: "Ingeniería Electricista",
    4: "Ingeniería Electrónica",
    5: "Ingeniería en Agrimensura",
    6: "Ingeniería en Informática",
    7: "Ingeniería en Petroleo",
    8: "Ingeniería Industrial",
    9: "Ingeniería Mecánica",
    10: "Ingeniería Naval y Mecánica",
    11: "Ingeniería Química",
    12: "Lic. en Análisis de Sistemas",
}