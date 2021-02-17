import React from 'react';
import { Title } from './Title/Title'
import { ButtonMenu } from './ButtonMenu/ButtonMenu'
import { ResultsWindow } from './ResultsWindow/ResultsWindow'
import { Login } from "./Login/Login"
import ApiHandler from './API/ApiHandler'

interface ApplicationState {
    renderResults: string;
}

export class Application extends React.Component<{}, ApplicationState> {

    constructor(props: any) {
        super(props);
        this.state = {
            renderResults: ""
        }
        this.handleButtonClick = this.handleButtonClick.bind(this);
    }

    handleButtonClick(buttonId: string): void {
        this.setState({
            renderResults: buttonId
        });
    }

    render(): JSX.Element {

        return (
            <div>
                <Title />
                <Login />
                <div>
                    <ButtonMenu onClick={this.handleButtonClick} />
                    <ResultsWindow renderId={this.state.renderResults} />
                </div>
            </div>
        );
    }
}