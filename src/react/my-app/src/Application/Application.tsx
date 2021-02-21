import React from 'react';
import { Title } from './Title/Title'
import { ButtonMenu } from './ButtonMenu/ButtonMenu'
import { ResultsWindow } from './ResultsWindow/ResultsWindow'
import { Login } from "./Login/Login"
import CarreerMenu from "./CarreerMenu/CarreerMenu"
import ApiHandler from "./API/ApiHandler"

interface ApplicationState {
    renderResults: string,
    studentId: string,
    carreerId: number,
    carreerIds: number[]
    loggedIn: boolean
}

export class Application extends React.Component<{}, ApplicationState> {

    constructor(props: any) {
        super(props);
        this.state = {
            loggedIn: false,
            studentId: "",
            carreerId: 12,
            carreerIds: [],
            renderResults: ""
        }
        this.handleButtonClick = this.handleButtonClick.bind(this);
        this.handleSuccessfulLogin = this.handleSuccessfulLogin.bind(this);
        this.changeCurrentCarreerId = this.changeCurrentCarreerId.bind(this);
    }

    handleButtonClick(buttonId: string): void {
        this.setState({
            renderResults: buttonId
        });
    }

    async handleSuccessfulLogin(studentId: string): Promise<any> {
        let data: any;
        data = await new ApiHandler().getStudentData(studentId).then((d: any) => {
            return JSON.parse(d);
        });
        this.setState({
            loggedIn: true,
            studentId,
            carreerIds: Object.keys(data.data).map(key => parseInt(key)),
            carreerId: 12,
            renderResults: "help"
        })
    }

    changeCurrentCarreerId(carreerId: number): void {
        this.setState({
            carreerId
        })
    }

    render(): JSX.Element {

        return (
            <div>
                <Title />
                <Login successFulLoginHandler={this.handleSuccessfulLogin} initialSentInput={this.state.loggedIn} />
                {this.state.loggedIn ? <CarreerMenu onClick={this.changeCurrentCarreerId} studentId={this.state.studentId} selectedCarreerId={this.state.carreerId} loggedIn={this.state.loggedIn} carreerIds={this.state.carreerIds} /> : ""}
                <div>
                    <ButtonMenu onClick={this.handleButtonClick} enabledMenu={this.state.loggedIn && this.state.carreerId != 12} />
                    <ResultsWindow renderId={this.state.renderResults} studentId={this.state.studentId} carreerId={this.state.carreerId} />
                </div>
            </div>
        );
    }
}