import React from 'react'
import "./HelpWindow.css"

export class HelpWindow extends React.Component {

    render(): JSX.Element {

        return (
            <div className="helpWindow">
                <ul>
                    <li className="helpWindowDescription">DISPONIBLES: muestra en pantalla las materias en las cuales el alumno puede anotarse para cursar.</li>
                    <li className="helpWindowDescription">RESTANTES: pide ingresar el codigo de una materia, y muestra en pantalla las materias restantes por aprobar para poder cursar la materia de codigo ingresado.</li>
                    <li className="helpWindowDescription">CREDITOS: muestra en pantalla la cantidad de creditos obtenidos por el alumno a lo largo de la carrera.</li>
                    <li className="helpWindowDescription">APROBADAS: muestra en pantalla las materias ya aprobadas por el alumno.</li>
                    <li className="helpWindowDescription">ACTUALIZAR: ???</li>
                </ul>
            </div>
        );
    }
}