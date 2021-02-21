import React from 'react'
import "./CarreerMenu.css"
import ApiHandler from '../API/ApiHandler'


interface CarreerMenuProps {
    carreerId: number
    onClick: Function
    loggedIn: boolean
    studentId: string
}

interface CarreerMenuState {
    carreerIds: number[]
}

export default class CarreerMenu extends React.Component<CarreerMenuProps, CarreerMenuState> {

    constructor(props: any) {
        super(props);

        this.state = {
            carreerIds: []
        }

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

    componentDidMount(): void {
        new ApiHandler().getStudentData(this.props.studentId).then((d: any) => {
            const data: any = JSON.parse(d);
            this.setState({
                carreerIds: Object.keys(data.data).map(key => parseInt(key))
            });
        });
    }

    getCarreerNameButtonList(): JSX.Element[] {
        let i: number;
        var carreerNameDivList: JSX.Element[] = [];
        for (i = 1; i <= 11; i++) {
            if (!this.state.carreerIds.includes(i)) continue;
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
    12: "Escoja una carrera...",
    2: "Ingeniería Civil",
    1: "Ingeniería de Alimentos",
    3: "Ingeniería Electricista",
    4: "Ingeniería Electrónica",
    0: "Ingeniería en Agrimensura",
    6: "Ingeniería en Informática",
    9: "Ingeniería en Petroleo",
    5: "Ingeniería Industrial",
    7: "Ingeniería Mecánica",
    8: "Ingeniería Naval y Mecánica",
    10: "Ingeniería Química",
    11: "Lic. en Análisis de Sistemas",
}
