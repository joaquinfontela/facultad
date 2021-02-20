import React from 'react';
import { Title } from './Title/Title'
import { ButtonMenu } from './ButtonMenu/ButtonMenu'
import { ResultsWindow } from './ResultsWindow/ResultsWindow'
import { Login } from "./Login/Login"
import CarreerMenu from "./CarreerMenu/CarreerMenu"

interface ApplicationState {
    renderResults: string,
    studentId: string,
    carreerId: number,
    loggedIn: boolean
}

export class Application extends React.Component<{}, ApplicationState> {

    constructor(props: any) {
        super(props);
        this.state = {
            loggedIn: false,
            studentId: "",
            carreerId: 0,
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

    handleSuccessfulLogin(studentId: string): void {
        this.setState({
            loggedIn: true,
            studentId
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
                <CarreerMenu onClick={this.changeCurrentCarreerId} carreerId={this.state.carreerId} loggedIn={this.state.loggedIn} />
                <div>
                    <ButtonMenu onClick={this.handleButtonClick} enabledMenu={this.state.loggedIn && this.state.carreerId != 0} />
                    <ResultsWindow renderId={this.state.renderResults} studentId={this.state.studentId} carreerId={this.state.carreerId} />
                </div>
            </div>
        );
    }
}